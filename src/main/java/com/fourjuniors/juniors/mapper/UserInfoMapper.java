package com.fourjuniors.juniors.mapper;

import com.fourjuniors.juniors.model.dto.response.UserInfoResponse;
import com.fourjuniors.juniors.security.model.entity.User;

public class UserInfoMapper {

    public static UserInfoResponse mapToDto(User user) {
        return UserInfoResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .lastname(user.getLastname())
                .profile(user.getProfile())
                .stack(user.getStack())
                .experience(user.getExperience())
                .portfolio(user.getPortfolio())
                .build();
    }
}
