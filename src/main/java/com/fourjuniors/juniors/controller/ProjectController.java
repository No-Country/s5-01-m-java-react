package com.fourjuniors.juniors.controller;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.model.dto.ImageDto;
import com.fourjuniors.juniors.model.dto.request.ProjectRequest;
import com.fourjuniors.juniors.model.dto.request.TeamRequest;
import com.fourjuniors.juniors.model.dto.response.ProjectCardResponse;
import com.fourjuniors.juniors.model.dto.response.ProjectResponse;
import com.fourjuniors.juniors.model.entity.Image;
import com.fourjuniors.juniors.model.entity.Project;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.service.UserService;
import com.fourjuniors.juniors.service.ImageService;
import com.fourjuniors.juniors.service.ProjectService;
import com.fourjuniors.juniors.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    private final S3Service s3Service;

    private final ImageService imageService;

    private final UserService userService;

    @GetMapping("/projects")
    private ResponseEntity<List<ProjectCardResponse>> listAllProjects() {

        List<ProjectCardResponse> response = projectService.listProjects();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/topTen")
    private ResponseEntity<List<ProjectCardResponse>> listTopTenProjects() {

        List<ProjectCardResponse> response = projectService.listTopTenProjects();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    private ResponseEntity<ProjectResponse> getProjectById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        ProjectResponse response = projectService.getProject(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/projects", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<ProjectResponse> createProject(Authentication authentication,
                                                          @RequestPart(name = "project") ProjectRequest request,
                                                          @RequestPart(name = "file") MultipartFile image) throws ResourceNotFoundException, AttributeException {

        Set<User> team = new HashSet<>();
        User user = userService.getUserByEmail(authentication.getName());
        team.add(user);

        Image imageDB = null;
        if (image.getContentType().equals("image/webp") || image.getContentType().equals("image/jpg")
                || image.getContentType().equals("image/jpeg") || image.getContentType().equals("image/png")
                || image.getContentType().equals("image/svg+xml")) {
            try {
                if (image.getBytes().length > 1048576)
                    throw new AttributeException("The image size must be less than or equal to 1mb");

                String key = s3Service.putObject(image);
                String path = s3Service.getObjectUrl(key);
                ImageDto imageDto = new ImageDto();
                imageDto.setKeyBucket(key);
                imageDto.setPath(path);

                imageDB = imageService.saveImage(imageDto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        ProjectResponse response = projectService.createProject(request, team, imageDB);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/projects/{id}/addMembers", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<ProjectResponse> addMembersToTeam(Authentication authentication,
                                                          @PathVariable Long id,
                                                          @RequestBody TeamRequest request) throws AttributeException, ResourceNotFoundException {

        if(request.getTeam().length == 0)
            throw new AttributeException("The array cant be empty");

        User user = userService.getUserByEmail(authentication.getName());
        ProjectResponse projectResponse = projectService.getProject(id);

        Optional<Project> ownProject = user.getProjects().stream()
                .filter(project -> project.getId() == projectResponse.getId())
                .findAny();

        if(!ownProject.isPresent())
            throw new AttributeException("You can't add members to a team you're not part of");

        // Get user information by email
        Set<User> team = Arrays.stream(request.getTeam())
                .map(email -> {
                    try {
                        return userService.getUserByEmail(email);
                    } catch (ResourceNotFoundException e) {
                        throw new UsernameNotFoundException(String.format("the user %s not exists", email));
                    }
                })
                .collect(Collectors.toSet());

        ProjectResponse response = projectService.addMembersToTeam(team, ownProject.get());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
