package io.clinicway.dh.connector.terra.feature.person.mapper;

import io.clinicway.dh.connector.terra.datasource.terra.entity.PersonContainer;
import io.clinicway.dh.connector.terra.feature.person.dto.PersonDto;
import io.clinicway.dh.connector.terra.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends AbstractMapper<PersonContainer, PersonDto> {

    @Autowired
    public PersonMapper() {
        super(PersonContainer.class, PersonDto.class);
    }
}
