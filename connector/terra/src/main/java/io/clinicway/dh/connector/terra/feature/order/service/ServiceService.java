package io.clinicway.dh.connector.terra.feature.order.service;

import io.clinicway.dh.connector.terra.feature.order.dto.ServiceDto;

import java.util.List;

public interface ServiceService {
    List<ServiceDto> getListByOrder(String orderId);
}
