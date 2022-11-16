package com.fourjuniors.juniors.security.controller;

import com.tutorial.crudmongoback.exceptions.AttributteException;
import com.tutorial.crudmongoback.security.dto.CreateUserDto;
import com.tutorial.crudmongoback.security.dto.JwtTokenDto;
import com.tutorial.crudmongoback.security.dto.LoginUserDto;
import com.tutorial.crudmongoback.security.entity.User;
import com.tutorial.crudmongoback.security.service.UserService;
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
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> create(@Valid @RequestBody CreateUserDto dto) throws AttributteException {
        return ResponseEntity.ok(userService.create(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody LoginUserDto dto) throws AttributteException {
        JwtTokenDto jwtTokenDto = userService.login(dto);
        return ResponseEntity.ok(jwtTokenDto);
    }
}
