package com.fourjuniors.juniors.model.dto.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserInfoResponse {

    private Long id;
    private String email;
    private String name;
    private String lastname;
    private String profile;
    private String stack;
    private String experience;
    private String portfolio;
}
