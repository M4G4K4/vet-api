package com.pedro.models.mapper;

import com.pedro.models.dto.user.UserCreate;
import com.pedro.models.dto.user.UserRead;
import com.pedro.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserRead userToUserRead(User user);

    User userCreateToUser(UserCreate userCreate);

}