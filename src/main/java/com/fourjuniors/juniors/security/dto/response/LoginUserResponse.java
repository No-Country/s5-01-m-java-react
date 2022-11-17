package com.fourjuniors.juniors.security.dto.response;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LoginUserResponse {
    private Long userId;
    private String username;
    private String token;
}
