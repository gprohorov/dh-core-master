package io.clinicway.dh.connector.terra.mapper;

import io.clinicway.dh.connector.terra.dto.AbstractDto;
import io.clinicway.dh.connector.terra.entity.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
