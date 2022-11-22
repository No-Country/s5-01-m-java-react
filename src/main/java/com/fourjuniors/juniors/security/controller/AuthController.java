package com.fourjuniors.juniors.security.controller;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.security.model.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.model.dto.request.LoginUserRequest;
import com.fourjuniors.juniors.security.model.dto.response.CreateUserResponse;
import com.fourjuniors.juniors.security.model.dto.response.LoginUserResponse;
import com.fourjuniors.juniors.security.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> create(@Valid @RequestBody CreateUserRequest request) throws AttributeException {
        return ResponseEntity.ok(userServiceImpl.create(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> login(@Valid @RequestBody LoginUserRequest dto) throws AttributeException {
        LoginUserResponse response = userServiceImpl.login(dto);
        return ResponseEntity.ok(response);
    }
}
