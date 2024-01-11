package io.clinicway.dh.api.consumer.feature.person.mapper;

import io.clinicway.dh.api.consumer.feature.person.entity.PersonContainer;
import io.clinicway.dh.api.consumer.feature.person.dto.PersonDto;
import io.clinicway.dh.api.consumer.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends AbstractMapper<PersonContainer, PersonDto> {

    @Autowired
    public PersonMapper() {
        super(PersonContainer.class, PersonDto.class);
    }
}
