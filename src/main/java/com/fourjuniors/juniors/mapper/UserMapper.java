package com.fourjuniors.juniors.mapper;

import com.fourjuniors.juniors.dto.UserDto;
import com.fourjuniors.juniors.entity.User;
import org.springframework.web.bind.annotation.Mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Primary;



@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    @Mappings({
            @Mapping(target = "role", source = "role.roleName"),


    })
    public UserDto userToUserResponse(User user);




}