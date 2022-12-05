package com.fourjuniors.juniors.service.implementation;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.model.dto.request.RatingRequest;
import com.fourjuniors.juniors.model.entity.Project;
import com.fourjuniors.juniors.model.entity.Rating;
import com.fourjuniors.juniors.model.enums.RatingEnum;
import com.fourjuniors.juniors.repository.ProjectRepository;
import com.fourjuniors.juniors.repository.RatingRepository;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.service.RatingService;
import com.fourjuniors.juniors.utils.RatingUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepo;

    private final ProjectRepository projectRepo;

    public RatingServiceImpl(RatingRepository ratingRepo,
                             ProjectRepository projectRepo) {
        this.ratingRepo = ratingRepo;
        this.projectRepo = projectRepo;
    }

    @Override
    public void saveRating(RatingRequest request, User user, Long projectId)
            throws AttributeException, ResourceNotFoundException {

        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("The project does not exist"));

        Optional<Project> ownProjectFound = user.getProjects().stream()
                .filter(ownProject -> ownProject.getId() == projectId)
                .findFirst();

        if (ownProjectFound.isPresent())
            throw new AttributeException("You cant rating your own project");

        Optional<Rating> ratingFound = ratingRepo.findByProjectAndUser(project.getId(), user.getId());
        ratingFound.ifPresent(rating -> ratingRepo.deleteById(rating.getId()));

        RatingEnum ratingEnum = RatingUtils.getRatingEnum(request.getRating());

        Rating rating = new Rating();
        rating.setValue(ratingEnum);
        rating.setUser(user);
        rating.setProject(project);

        ratingRepo.save(rating);
    }

}
