package io.clinicway.dh.api.consumer.feature.profile.service;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.profile.dto.ProfileDto;

import java.util.Optional;

public interface ProfileService {
    Optional<ProfileDto> getByPhoneNumber(String phone) throws ClientNotFoundException;
}
