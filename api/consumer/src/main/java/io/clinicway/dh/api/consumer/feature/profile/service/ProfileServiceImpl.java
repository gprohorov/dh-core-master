package io.clinicway.dh.api.consumer.feature.profile.service;

import io.clinicway.dh.api.consumer.feature.profile.entity.ProfileContainer;
import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.profile.dto.ProfileDto;
import io.clinicway.dh.api.consumer.feature.profile.mapper.ProfileMapper;
import io.clinicway.dh.api.consumer.proxy.ResourceServerProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

    private final ProfileMapper mapper;

    private final ResourceServerProxy resourceServerProxy;

    public ProfileServiceImpl(ProfileMapper mapper, ResourceServerProxy resourceServerProxy) {
        this.mapper = mapper;
        this.resourceServerProxy = resourceServerProxy;
    }

    @Override
    public Optional<ProfileDto> getByPhoneNumber(String phone) throws ClientNotFoundException {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);

        ResponseEntity<ProfileContainer> response = resourceServerProxy.getRequest("/api/person", HttpMethod.GET, ProfileContainer.class, params);

        if (response.hasBody()) {
            ProfileContainer profile = response.getBody();

            return Optional.of(mapper.toDto(profile));
        }

        return Optional.empty();
    }
}
