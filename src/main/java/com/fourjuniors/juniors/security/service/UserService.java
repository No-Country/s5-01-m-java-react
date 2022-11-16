package com.fourjuniors.juniors.security.service;

import com.tutorial.crudmongoback.exceptions.AttributteException;
import com.tutorial.crudmongoback.exceptions.ResourceNotFoundException;
import com.tutorial.crudmongoback.security.dto.CreateUserDto;
import com.tutorial.crudmongoback.security.dto.JwtTokenDto;
import com.tutorial.crudmongoback.security.dto.LoginUserDto;
import com.tutorial.crudmongoback.security.entity.Role;
import com.tutorial.crudmongoback.security.entity.User;
import com.tutorial.crudmongoback.security.enums.RoleEnum;
import com.tutorial.crudmongoback.security.jwt.JwtProvider;
import com.tutorial.crudmongoback.security.repository.RoleRepository;
import com.tutorial.crudmongoback.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;

    public User create(CreateUserDto createUserDto) throws AttributteException {
        if (userRepository.existsByUsername(createUserDto.getUsername()))
            throw new AttributteException("username is already in use");
        if (userRepository.existsByEmail(createUserDto.getEmail()))
            throw new AttributteException("email is already in use");

        String password = passwordEncoder.encode(createUserDto.getPassword());

        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(password);
        user.setEmail(createUserDto.getEmail());

        createUserDto.getRoles()
                .forEach(role -> {
                    try {

                        Role roleFinded = roleRepository.findByName(RoleEnum.valueOf(role))
                                .orElseThrow(() -> new ResourceNotFoundException("role does not exist"));
                        user.getRoles().add(roleFinded);
                    } catch (ResourceNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });

        return userRepository.save(user);

    }

    public JwtTokenDto login(LoginUserDto dto){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new JwtTokenDto(token);
    }
}
