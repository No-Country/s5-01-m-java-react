package com.fourjuniors.juniors.security.service.implementation;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.security.dto.mapper.CreateUserMapper;
import com.fourjuniors.juniors.security.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.dto.request.LoginUserRequest;
import com.fourjuniors.juniors.security.dto.response.CreateUserResponse;
import com.fourjuniors.juniors.security.dto.response.LoginUserResponse;
import com.fourjuniors.juniors.security.entity.User;
import com.fourjuniors.juniors.security.entity.Role;
import com.fourjuniors.juniors.security.enums.RoleEnum;
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
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AttributeException("username is already in use");
        if (userRepository.existsByEmail(request.getEmail()))
            throw new AttributeException("email is already in use");

        String password = passwordEncoder.encode(request.getPassword());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(password);
        user.setEmail(request.getEmail());
        try {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
                    .orElseThrow(() -> new ResourceNotFoundException("role does not exist"));
            user.getRoles().add(userRole);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        User userInserted = userRepository.save(user);
        return CreateUserMapper.mapToDto(userInserted);
    }

    public LoginUserResponse login(LoginUserRequest request){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new LoginUserResponse(userDetails.getId(), userDetails.getUsername(), token);
    }
}
