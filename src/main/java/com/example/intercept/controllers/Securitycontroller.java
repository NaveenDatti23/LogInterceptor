package com.example.intercept.controllers;

import com.example.intercept.services.Logservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Securitycontroller {

  @Autowired
  private Logservice logservice;

  @PostMapping("/printHeaders")
  public ResponseEntity<String> helloworld(
      @RequestBody(required = false) Object requestBody) {
    return new ResponseEntity<String>(
        String.format("Hello World"), HttpStatus.OK);
  }

  @GetMapping("/printHeaders/{id}")
  public ResponseEntity<String> listAllHeaders(@PathVariable String id) {
    return new ResponseEntity<String>(
        String.format("get api is called successfully"), HttpStatus.OK);
  }

  @PutMapping("/printHeaders/{id}")
  public ResponseEntity<String> updateapi(@PathVariable String id,
                                          @RequestBody(required = false) Object requestBody) {
    return new ResponseEntity<String>(
        String.format("update api is called successfully"), HttpStatus.OK);
  }

  @PatchMapping("/printHeaders/{id}")
  public ResponseEntity<String> patchapi(@PathVariable String id,
                                         @RequestBody(required = false) Object body) {
    return new ResponseEntity<String>(
        String.format("Patch api is called successfully"), HttpStatus.OK);
  }
}
