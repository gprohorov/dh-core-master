package io.clinicway.dh.api.consumer.feature.order.service;

import io.clinicway.dh.api.consumer.feature.order.dto.OrdersDto;
import io.clinicway.dh.api.consumer.feature.order.entity.OrderContainer;
import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.order.dto.OrderDto;
import io.clinicway.dh.api.consumer.feature.order.entity.OrdersContainer;
import io.clinicway.dh.api.consumer.feature.order.mapper.OrderMapper;
import io.clinicway.dh.api.consumer.feature.order.mapper.OrdersMapper;
import io.clinicway.dh.api.consumer.proxy.ResourceServerProxy;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrdersMapper ordersMapper;

    private final ResourceServerProxy resourceServerProxy;

    public OrderServiceImpl(OrderMapper orderMapper, OrdersMapper ordersMapper, ResourceServerProxy resourceServerProxy) {
        this.orderMapper = orderMapper;
        this.ordersMapper = ordersMapper;
        this.resourceServerProxy = resourceServerProxy;
    }

    @Override
    public Optional<OrderDto> getById(String id) throws ClientNotFoundException {
        ResponseEntity<OrderContainer> response = resourceServerProxy.getRequest("/api/orders", HttpMethod.GET, OrderContainer.class);

        if (response.hasBody()) {
            OrderContainer order = response.getBody();

            return Optional.of(orderMapper.toDto(order));
        }

        return Optional.empty();
    }

    @Override
    public Optional<OrdersDto> getByPersonId(String personId, Integer page) throws ClientNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("personId", personId);
        params.put("page", page.toString());

        ResponseEntity<OrdersContainer> response = resourceServerProxy.getRequest("/api/orders", HttpMethod.GET, OrdersContainer.class, params);

        if (response.hasBody()) {
            OrdersContainer orders = response.getBody();

            assert orders != null;
            return Optional.of(ordersMapper.toDto(orders));
        }

        return Optional.empty();
    }
}
