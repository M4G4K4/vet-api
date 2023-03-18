package com.pedro.services;

import com.pedro.models.dto.user.UserCreate;
import com.pedro.models.dto.user.UserRead;
import com.pedro.models.entity.User;
import com.pedro.models.mapper.UserMapper;
import com.pedro.utils.exception.ErrorCode;
import com.pedro.utils.exception.ServiceException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    protected UserMapper mapper;

    @Transactional
    public UserRead createUser(final UserCreate userCreate) {

        User.findByNif(userCreate.getNif()).ifPresent( exception -> { throw new ServiceException(ErrorCode.USER_CC_ALREADY_EXISTS); } );
        User.findByEmail(userCreate.getEmail()).ifPresent(exception -> { throw new ServiceException(ErrorCode.USER_EMAIL_ALREADY_EXISTS); });
        User.findByCardIdentification(userCreate.getCardIdentification()).ifPresent(exception -> { throw new ServiceException(ErrorCode.USER_CC_ALREADY_EXISTS); });

        final User user = mapper.userCreateToUser(userCreate);

        user.persist();

        return mapper.userToUserRead(user);
    }
}
