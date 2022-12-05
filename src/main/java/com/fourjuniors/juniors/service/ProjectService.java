package com.fourjuniors.juniors.service;

import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.model.dto.request.ProjectRequest;
import com.fourjuniors.juniors.model.dto.response.ProjectCardResponse;
import com.fourjuniors.juniors.model.dto.response.ProjectResponse;
import com.fourjuniors.juniors.model.entity.Image;
import com.fourjuniors.juniors.security.model.entity.User;

import java.util.List;
import java.util.Set;

public interface ProjectService {

    List<ProjectCardResponse> listProjects();
    List<ProjectCardResponse> listTopTenProjects();

    ProjectResponse getProject(Long id) throws ResourceNotFoundException;

    ProjectResponse createProject(ProjectRequest projectRequest, Set<User> team, Image image);

    void deleteProject(Long id);

}
