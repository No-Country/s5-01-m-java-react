package com.fourjuniors.juniors.security.model.mapper;
import com.fourjuniors.juniors.security.model.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.model.dto.response.CreateUserResponse;

import java.util.ArrayList;

public class CreateUserMapper {

    public static CreateUserResponse mapToDto(User user){
        return CreateUserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .stack(user.getStack())
                .portfolio(user.getPortfolio())
                .experience(user.getExperience())
                .lastname(user.getLastname())
                .profile(user.getProfile())
                .experience(user.getExperience())
                .roles(user.getRoles())
                .build();
    }

    public static User mapToEntity(CreateUserRequest request, String passwordEncoded){

        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoded)
                .lastname(request.getLastname())
                .portfolio(request.getPortfolio())
                .profile(request.getProfile())
                .experience(request.getExperience())
                .stack(request.getStack())
                .roles(new ArrayList<>())
                .build();
    }
}
