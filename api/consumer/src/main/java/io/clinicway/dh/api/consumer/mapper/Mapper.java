package io.clinicway.dh.api.consumer.mapper;

import io.clinicway.dh.api.consumer.dto.AbstractDto;
import io.clinicway.dh.api.consumer.entity.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
