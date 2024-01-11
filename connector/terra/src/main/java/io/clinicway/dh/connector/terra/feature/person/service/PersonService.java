package io.clinicway.dh.connector.terra.feature.person.service;

import io.clinicway.dh.connector.terra.feature.person.dto.PersonDto;

public interface PersonService {
    PersonDto getByPhoneNumber(String phone);
}
