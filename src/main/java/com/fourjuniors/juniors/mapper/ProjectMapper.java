package com.fourjuniors.juniors.mapper;

import com.fourjuniors.juniors.model.dto.StackDto;
import com.fourjuniors.juniors.model.dto.request.ProjectRequest;
import com.fourjuniors.juniors.model.dto.response.ProjectResponse;
import com.fourjuniors.juniors.model.dto.response.UserInfoResponse;
import com.fourjuniors.juniors.model.entity.Image;
import com.fourjuniors.juniors.model.entity.Project;
import com.fourjuniors.juniors.security.model.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectResponse mapToDto(Project project,
                                           Set<User> team,
                                           double rating) {

        Set<UserInfoResponse> teamInfo = team.stream()
                .map(UserInfoMapper::mapToDto)
                .collect(Collectors.toSet());

        String[] techs = project.getStack().split(", ");
        StackDto stackDto = StackDto.builder()
                .tech1(techs[0])
                .tech2(techs[1])
                .build();

        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .type(project.getType())
                .stack(stackDto)
                .description(project.getDescription())
                .link(project.getLink())
                .image(project.getImage().getPath())
                .rating(rating)
                .team(teamInfo)
                .build();
    }

    public static Project mapToEntity(ProjectRequest request, Image image) {

        return Project.builder()
                .name(request.getName())
                .type(request.getType())
                .stack(String.format("%s, %s",
                        request.getStack().getTech1(),
                        request.getStack().getTech2()))
                .description(request.getDescription())
                .link(request.getLink())
                .image(image)
                .build();
    }
}
