package com.fourjuniors.juniors.controller;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.model.dto.request.RatingRequest;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.service.UserService;
import com.fourjuniors.juniors.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RatingController {

    private final RatingService ratingService;

    private final UserService userService;

    @PostMapping("/projects/{id}/rating")
    public ResponseEntity<String> createRating(Authentication authentication,
                                               @PathVariable(value = "id") Long id,
                                               @RequestBody RatingRequest request)
            throws ResourceNotFoundException, AttributeException {
        User user = userService.getUserByEmail(authentication.getName());

        ratingService.saveRating(request, user, id);

        return new ResponseEntity<>("Your rating has been saved", HttpStatus.OK);
    }
}
