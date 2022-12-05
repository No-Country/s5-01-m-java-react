package com.fourjuniors.juniors.model.dto.response;

import com.fourjuniors.juniors.model.dto.StackDto;
import lombok.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ProjectResponse {

    private Long id;
    private String name;
    private String type;
    private StackDto stack;
    private String description;
    private String link;
    private String image;
    private double rating;
    private Set<UserInfoResponse> team;

}
