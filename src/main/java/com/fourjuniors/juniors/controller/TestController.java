package com.fourjuniors.juniors.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/allUsers")
    public ResponseEntity<String> allUsers(){
        return ResponseEntity.ok("Welcome user! ");
    }

    @GetMapping("/onlyAdmin")
    public ResponseEntity<String> onlyAdmin(){
        return ResponseEntity.ok("Welcome admin! ");
    }
}
