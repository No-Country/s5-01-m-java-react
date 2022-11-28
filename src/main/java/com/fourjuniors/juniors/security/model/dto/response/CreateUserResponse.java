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

    private String email;
    private String password;
    private String name;
    private String lastname;
    private String profile;
    private String stack;
    private String experience;
    private String portfolio;
    private List<Role> roles;
}
