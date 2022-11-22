package com.fourjuniors.juniors.security.model.dto.response;

import com.fourjuniors.juniors.security.model.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserResponse {

    private String username;
    private String email;
    private String password;
    private String lastname;
    private String portfolio;
    private String profile;
    private String experience;
    private String stack;
    private List<Role> roles;
}
