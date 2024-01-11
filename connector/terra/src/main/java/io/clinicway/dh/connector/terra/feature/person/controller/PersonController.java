package io.clinicway.dh.connector.terra.feature.person.controller;

import io.clinicway.dh.connector.terra.feature.person.dto.PersonDto;
import io.clinicway.dh.connector.terra.feature.person.service.PersonService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "Person", path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
@Api("Person")
@ApiOperation(value = "Persons API", notes = "Persons API", nickname = "Person")
public class PersonController {
    final
    PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @ApiOperation(value = "Get a person by phone number", notes = "Returns a Person entity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The person was not found")
    })
    @GetMapping("/person")
    public ResponseEntity<PersonDto> getPersonByPhone(
            @RequestParam(value = "phone")
            @ApiParam(name = "phone", value = "Phone number", example = "380112345678", required = true)
            String phone
    ) {
        if (phone.startsWith("38")) {
            phone = phone.substring(2);
        }

        return ResponseEntity.ok(service.getByPhoneNumber(phone));
    }
}
