package com.fourjuniors.juniors.security.service;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.exception.ResourceNotFoundException;
import com.fourjuniors.juniors.security.model.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.model.dto.request.LoginUserRequest;
import com.fourjuniors.juniors.security.model.dto.response.CreateUserResponse;
import com.fourjuniors.juniors.security.model.dto.response.LoginUserResponse;
import com.fourjuniors.juniors.security.model.entity.User;

public interface UserService {
    CreateUserResponse create(CreateUserRequest request) throws AttributeException;
    LoginUserResponse login(LoginUserRequest request) throws AttributeException;
    User getUserByEmail(String email) throws ResourceNotFoundException;
}
