package com.fourjuniors.juniors.security.mapper;
import com.fourjuniors.juniors.security.model.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.model.dto.response.CreateUserResponse;

import java.util.ArrayList;

public class CreateUserMapper {

    public static CreateUserResponse mapToDto(User user){
        return CreateUserResponse.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .lastname(user.getLastname())
                .profile(user.getProfile())
                .stack(user.getStack())
                .experience(user.getExperience())
                .portfolio(user.getPortfolio())
                .roles(user.getRoles())
                .build();
    }

    public static User mapToEntity(CreateUserRequest request, String passwordEncoded){

        return User.builder()
                .email(request.getEmail())
                .password(passwordEncoded)
                .name(request.getName())
                .lastname(request.getLastname())
                .profile(request.getProfile())
                .stack(request.getStack())
                .experience(request.getExperience())
                .portfolio(request.getPortfolio())
                .roles(new ArrayList<>())
                .build();
    }
}
