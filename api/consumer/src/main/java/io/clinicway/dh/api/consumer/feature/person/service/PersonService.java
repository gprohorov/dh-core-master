package io.clinicway.dh.api.consumer.feature.person.service;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.person.dto.PersonDto;

import java.util.Optional;

public interface PersonService {
    Optional<PersonDto> getByPhoneNumber(String phone) throws ClientNotFoundException;
}
