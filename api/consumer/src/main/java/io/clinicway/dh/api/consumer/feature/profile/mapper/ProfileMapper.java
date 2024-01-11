package io.clinicway.dh.api.consumer.feature.profile.mapper;

import io.clinicway.dh.api.consumer.feature.profile.entity.ProfileContainer;
import io.clinicway.dh.api.consumer.feature.profile.dto.ProfileDto;
import io.clinicway.dh.api.consumer.mapper.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper extends AbstractMapper<ProfileContainer, ProfileDto> {
    @Autowired
    public ProfileMapper() {
        super(ProfileContainer.class, ProfileDto.class);
    }
}
