package com.fourjuniors.juniors.security.service;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.security.dto.request.CreateUserRequest;
import com.fourjuniors.juniors.security.dto.request.LoginUserRequest;
import com.fourjuniors.juniors.security.dto.response.CreateUserResponse;
import com.fourjuniors.juniors.security.dto.response.LoginUserResponse;

public interface UserService {
    CreateUserResponse create(CreateUserRequest request) throws AttributeException;
    LoginUserResponse login(LoginUserRequest request) throws AttributeException;
}
