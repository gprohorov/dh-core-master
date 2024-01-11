package io.clinicway.dh.api.consumer.feature.profile.controller;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.profile.dto.ProfileDto;
import io.clinicway.dh.api.consumer.feature.profile.service.ProfileService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(name = "Profile", path = "/api/profile", produces = "application/json")
@CrossOrigin(origins = "*")
@Api("Profile")
@ApiOperation(value = "Profile API", notes = "Profile API", nickname = "Profile")
public class ProfileController {
    Logger logger = LoggerFactory.getLogger(ProfileController.class);
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @ApiOperation(value = "Get a Profile by token", notes = "Returns a Profile entity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The profile was not found")
    })
    @GetMapping()
    public ResponseEntity<Object> getProfile(
            @RequestAttribute("preferred_username") String phone
    ) throws ClientNotFoundException {
        Optional<ProfileDto> profile = profileService.getByPhoneNumber(phone);

        return profile.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
