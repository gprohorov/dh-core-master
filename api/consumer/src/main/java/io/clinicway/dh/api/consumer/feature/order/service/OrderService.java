package io.clinicway.dh.api.consumer.feature.order.service;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.order.dto.OrderDto;
import io.clinicway.dh.api.consumer.feature.order.dto.OrdersDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<OrderDto> getById(String id) throws ClientNotFoundException;

    Optional<OrdersDto> getByPersonId(String personId, Integer page) throws ClientNotFoundException;
}
