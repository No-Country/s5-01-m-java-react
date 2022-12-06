package com.fourjuniors.juniors.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TeamRequest {
    @NotBlank(message = "team is mandatory")
    private String[] team;
}
