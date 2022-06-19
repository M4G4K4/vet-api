package com.pedro.models.mapper;

import com.pedro.models.dto.user.UserRead;
import com.pedro.models.entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper {

    public UserRead userToUserRead(final User user) {
        return UserRead.builder()
                .id(user.id)
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .fullName(user.getFullName())
                .build();
    }
}
