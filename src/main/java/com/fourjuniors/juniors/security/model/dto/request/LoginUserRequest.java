package com.fourjuniors.juniors.security.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LoginUserRequest {
    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;
}
