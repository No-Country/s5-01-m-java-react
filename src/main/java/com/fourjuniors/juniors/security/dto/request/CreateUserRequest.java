package com.fourjuniors.juniors.security.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "username is mandatory")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "username is mandatory")
    private String password;
    @NotBlank(message = "lastname is mandatory")
    private String lastname;
    @NotBlank(message = "portfolio is mandatory")
    private String portfolio;
    @NotBlank(message = "profile is mandatory")
    private String profile;
    @NotBlank(message = "experience is mandatory")
    private String experience;
    @NotBlank(message = "stack is mandatory")
    private String stack;
}
