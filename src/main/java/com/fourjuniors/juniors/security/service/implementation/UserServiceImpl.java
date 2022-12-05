package com.fourjuniors.juniors.security.service.implementation;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.security.mapper.CreateUserMapper;
import com.fourjuniors.juniors.security.model.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.model.dto.request.LoginUserRequest;
import com.fourjuniors.juniors.security.model.dto.response.CreateUserResponse;
import com.fourjuniors.juniors.security.model.dto.response.LoginUserResponse;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.model.entity.Role;
import com.fourjuniors.juniors.security.model.enums.RoleEnum;
import com.fourjuniors.juniors.security.jwt.JwtProvider;
import com.fourjuniors.juniors.security.repository.RoleRepository;
import com.fourjuniors.juniors.security.repository.UserRepository;
import com.fourjuniors.juniors.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

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

    public CreateUserResponse create(CreateUserRequest request) throws AttributeException {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new AttributeException("email is already in use");

        String password = passwordEncoder.encode(request.getPassword());

        User user = CreateUserMapper.mapToEntity(request, password);

        try {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new ResourceNotFoundException("role does not exist"));
            user.getRoles().add(userRole);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        User userInserted = userRepository.save(user);
        return CreateUserMapper.mapToDto(userInserted);
    }

    public LoginUserResponse login(LoginUserRequest request) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new LoginUserResponse(userDetails.getId(), userDetails.getUsername(), token);
    }

    @Override
    public User getUserByEmail(String email) throws ResourceNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("user does not exist"));
    }
}
