package com.fourjuniors.juniors.mapper;

import com.fourjuniors.juniors.model.dto.StackDto;
import com.fourjuniors.juniors.model.dto.response.ProjectCardResponse;
import com.fourjuniors.juniors.model.entity.Project;

public class ProjectCardMapper {

    public static ProjectCardResponse mapToDto(Project project, double rating){

        String[] techs = project.getStack().split(", ");
        StackDto stackDto = StackDto.builder()
                .tech1(techs[0])
                .tech2(techs[1])
                .build();

        return ProjectCardResponse.builder()
                .id(project.getId())
                .image(project.getImage().getPath())
                .name(project.getName())
                .stack(stackDto)
                .rating(rating)
                .build();
    }
}
