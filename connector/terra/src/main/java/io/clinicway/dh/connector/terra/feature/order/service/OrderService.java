package io.clinicway.dh.connector.terra.feature.order.service;

import io.clinicway.dh.connector.terra.feature.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getListByPerson(String personId, int perPage, int offset);

    OrderDto getOne(String orderId);

    int countByPerson(String personId);
}
