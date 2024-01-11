package io.clinicway.dh.connector.terra.feature.order.service;

import io.clinicway.dh.connector.terra.datasource.terra.entity.ServiceContainer;
import io.clinicway.dh.connector.terra.datasource.terra.repository.ServiceContainerRepository;
import io.clinicway.dh.connector.terra.feature.order.dto.ServiceDto;
import io.clinicway.dh.connector.terra.feature.order.mapper.ServiceMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {
    private final ServiceContainerRepository repository;
    private final ServiceMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    public ServiceServiceImpl(
            ServiceContainerRepository repository,
            ServiceMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ServiceDto> getListByOrder(String orderId) {
        List<ServiceContainer> services = repository.getOrderServices(orderId);

        return services.stream()
                .map(entity -> modelMapper.map(entity, ServiceDto.class))
                .collect(Collectors.toList());
    }
}
