package com.gebarowski.michal.speculatorapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    // TODO Replace with swagger
    @GetMapping("/")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok("Speculator API");
    }
}
