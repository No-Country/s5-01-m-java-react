package com.fourjuniors.juniors.service;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.model.dto.request.RatingRequest;
import com.fourjuniors.juniors.model.entity.Project;
import com.fourjuniors.juniors.security.model.entity.User;

public interface RatingService {

    void saveRating(RatingRequest request, User user, Long projectId) throws AttributeException, ResourceNotFoundException;

}
