package com.fourjuniors.juniors.model.dto.request;

import com.fourjuniors.juniors.model.dto.StackDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ProjectRequest {

    @NotBlank(message = "project name is mandatory")
    private String name;
    @NotBlank(message = "project type is mandatory")
    private String type;
    @NotBlank(message = "project stack is mandatory")
    private StackDto stack;
    @NotBlank(message = "project description is mandatory")
    private String description;
    @NotBlank(message = "project link is mandatory")
    private String link;

}
