package io.clinicway.dh.connector.terra.feature.order.mapper;

import io.clinicway.dh.connector.terra.datasource.terra.entity.OrderContainer;
import io.clinicway.dh.connector.terra.feature.order.dto.OrderDto;
import io.clinicway.dh.connector.terra.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends AbstractMapper<OrderContainer, OrderDto> {

    @Autowired
    public OrderMapper() {
        super(OrderContainer.class, OrderDto.class);
    }
}
