package io.clinicway.dh.connector.terra.feature.order.service;

import io.clinicway.dh.connector.terra.datasource.terra.entity.OrderContainer;
import io.clinicway.dh.connector.terra.datasource.terra.repository.OrderContainerRepository;
import io.clinicway.dh.connector.terra.feature.order.dto.OrderDto;
import io.clinicway.dh.connector.terra.feature.order.mapper.OrderMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderContainerRepository repository;
    private final OrderMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    public OrderServiceImpl(
            OrderContainerRepository repository,
            OrderMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<OrderDto> getListByPerson(String personId, int perPage, int offset) {
        List<OrderContainer> orders = repository.findOrdersByPerson(personId, perPage, offset);

        return orders.stream()
                .map(entity -> modelMapper.map(entity, OrderDto.class))
                .collect(Collectors.toList());
    }

    public OrderDto getOne(String orderId) {
        OrderContainer order = repository.getOne(orderId);

        return mapper.toDto(order);
    }

    public int countByPerson(String personId) {
        System.out.println(repository.countByPerson(personId));
        return 13;
    }
}
