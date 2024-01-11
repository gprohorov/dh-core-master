package io.clinicway.dh.api.consumer.feature.person.controller;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.person.dto.PersonDto;
import io.clinicway.dh.api.consumer.feature.person.service.PersonService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(name = "Person", path = "/api/person", produces = "application/json")
@CrossOrigin(origins = "*")
@Api("Person")
@ApiOperation(value = "Persons API", notes = "Persons API", nickname = "Person")
public class PersonController {
    Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ApiOperation(value = "Get a person by phone number", notes = "Returns a Person entity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The person was not found")
    })
    @GetMapping()
    public ResponseEntity<Object> getPersonByPhone(
            @RequestParam(value = "phone")
            @ApiParam(name = "phone", value = "Phone number", example = "0112345678", required = true)
            String phone
    ) throws ClientNotFoundException {
        Optional<PersonDto> person = personService.getByPhoneNumber(phone);

        return person.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
