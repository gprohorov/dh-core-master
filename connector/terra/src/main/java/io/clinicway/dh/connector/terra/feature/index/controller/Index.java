package io.clinicway.dh.connector.terra.feature.index.controller;

import io.clinicway.dh.connector.terra.datasource.terra.entity.Client;
import io.clinicway.dh.connector.terra.datasource.terra.entity.PersonContainer;
import io.clinicway.dh.connector.terra.datasource.terra.repository.ClientRepository;
import io.clinicway.dh.connector.terra.datasource.terra.repository.PersonContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
class Index {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PersonContainerRepository personContainerRepository;

    @GetMapping("/")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("sadfasd");
    }

    @Bean
    @GetMapping("/client")
    public ResponseEntity<String> client() {
//        Person person = personRepository.findOneByPhone("0662217679");

        Optional<Client> client = clientRepository.findById("829208c92fd94a29a3f1bd030cecb59f");
        if (client != null) {
            return ResponseEntity.ok().body(client.toString());
        } else {
            return ResponseEntity.ok().body("Client not found");
        }
    }

    @Bean
    @GetMapping("/person")
    public ResponseEntity<String> person() {
        PersonContainer personContainer = personContainerRepository.findOneByPhone("0662217679");

        if (personContainer != null) {
            return ResponseEntity.ok().body(personContainer.toString());
        } else {
            return ResponseEntity.ok().body("Person not found");
        }
    }
}
