package io.clinicway.dh.connector.terra.feature.person.service;

import io.clinicway.dh.connector.terra.datasource.terra.repository.PersonContainerRepository;
import io.clinicway.dh.connector.terra.feature.person.dto.PersonDto;
import io.clinicway.dh.connector.terra.feature.person.mapper.PersonMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonContainerRepository repository;
    private final PersonMapper mapper;

    public PersonServiceImpl(PersonContainerRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PersonDto getByPhoneNumber(String phone) {
        return mapper.toDto(repository.findOneByPhone(phone));
    }
}
