package com.fourjuniors.juniors.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
@Data
@Builder
public class UserDto {
    private String username;

    private String lastname;

    private String portfolio;

    private String email;

    private String profile;

    private String experience;

    private String stack;


}
