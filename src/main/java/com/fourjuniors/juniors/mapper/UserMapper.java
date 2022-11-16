package com.fourjuniors.juniors.mapper;

import com.fourjuniors.juniors.dto.UserDto;
import com.fourjuniors.juniors.entity.User;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.annotation.Primary;



@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role.roleName", target = "role")

    public UserDto userToUserDto(User user);

}