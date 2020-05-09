package com.gebarowski.michal.speculatorapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApacheController {

    @GetMapping("/hello")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok("Test");
    }
}
