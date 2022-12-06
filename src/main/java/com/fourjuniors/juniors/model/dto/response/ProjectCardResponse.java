package com.fourjuniors.juniors.model.dto.response;

import com.fourjuniors.juniors.model.dto.StackDto;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ProjectCardResponse {

    private Long id;
    private String image;
    private String name;
    private StackDto stack;
    private String type;
    private double rating;

}
