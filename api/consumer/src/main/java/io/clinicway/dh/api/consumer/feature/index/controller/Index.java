package io.clinicway.dh.api.consumer.feature.index.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class Index {
    @GetMapping
    public ResponseEntity<String> index() {
        System.out.println("dsfgasdfa");
        return ResponseEntity.ok().body("sadfasd");
    }
}
