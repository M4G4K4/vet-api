package com.pedro.services;

import com.pedro.models.dto.user.UserCreate;
import com.pedro.models.dto.user.UserRead;
import com.pedro.models.entity.User;
import com.pedro.models.mapper.UserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    protected UserMapper mapper;

    @Transactional
    public UserRead createUser(final UserCreate userCreate) {
        final User user = User.builder()
                .firstName(userCreate.getFirstName())
                .lastName(userCreate.getLastName())
                .cardIdentification(userCreate.getCardIdentification())
                .build();

        user.persist();

        return mapper.userToUserRead(user);
    }
}
