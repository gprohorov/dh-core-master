package io.clinicway.dh.api.consumer.feature.order.mapper;

import io.clinicway.dh.api.consumer.feature.order.entity.OrderContainer;
import io.clinicway.dh.api.consumer.feature.order.dto.OrderDto;
import io.clinicway.dh.api.consumer.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper  extends AbstractMapper<OrderContainer, OrderDto> {
    @Autowired
    public OrderMapper() {
        super(OrderContainer.class, OrderDto.class);
    }
}
