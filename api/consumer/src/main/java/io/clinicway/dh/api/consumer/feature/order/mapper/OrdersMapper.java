package io.clinicway.dh.api.consumer.feature.order.mapper;

import io.clinicway.dh.api.consumer.feature.order.dto.OrdersDto;
import io.clinicway.dh.api.consumer.feature.order.entity.OrdersContainer;
import io.clinicway.dh.api.consumer.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersMapper extends AbstractMapper<OrdersContainer, OrdersDto> {
    @Autowired
    public OrdersMapper() {
        super(OrdersContainer.class, OrdersDto.class);
    }
}
