package io.clinicway.dh.connector.terra.feature.order.mapper;

import io.clinicway.dh.connector.terra.datasource.terra.entity.ServiceContainer;
import io.clinicway.dh.connector.terra.feature.order.dto.ServiceDto;
import io.clinicway.dh.connector.terra.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper extends AbstractMapper<ServiceContainer, ServiceDto> {

    @Autowired
    public ServiceMapper() {
        super(ServiceContainer.class, ServiceDto.class);
    }
}
