package com.fourjuniors.juniors.security.dto.mapper;

import com.fourjuniors.juniors.security.dto.response.CreateUserResponse;
import com.fourjuniors.juniors.security.entity.User;

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
}
