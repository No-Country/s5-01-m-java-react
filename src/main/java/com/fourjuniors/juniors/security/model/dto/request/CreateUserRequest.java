package com.fourjuniors.juniors.security.model.dto.request;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateUserRequest {

    @NotBlank(message = "email is mandatory")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "lastname is mandatory")
    private String lastname;
    @NotBlank(message = "profile is mandatory")
    private String profile;
    @NotBlank(message = "stack is mandatory")
    private String stack;
    @NotBlank(message = "experience is mandatory")
    private String experience;
    @NotBlank(message = "portfolio is mandatory")
    private String portfolio;
}
