package io.clinicway.dh.api.consumer.feature.person.service;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.proxy.ResourceServerProxy;
import io.clinicway.dh.api.consumer.feature.person.entity.PersonContainer;
import io.clinicway.dh.api.consumer.feature.person.dto.PersonDto;
import io.clinicway.dh.api.consumer.feature.person.mapper.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final PersonMapper mapper;

    private final ResourceServerProxy resourceServerProxy;

    public PersonServiceImpl(PersonMapper mapper, ResourceServerProxy resourceServerProxy) {
        this.mapper = mapper;
        this.resourceServerProxy = resourceServerProxy;
    }

    @Override
    public Optional<PersonDto> getByPhoneNumber(String phone) throws ClientNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("phone", phone);

        ResponseEntity<PersonContainer> response = resourceServerProxy.getRequest("/api/person", HttpMethod.GET, PersonContainer.class, params);

        if (response.hasBody()) {
            PersonContainer person = response.getBody();

            return Optional.of(mapper.toDto(person));
        }

        return Optional.empty();
    }
}
