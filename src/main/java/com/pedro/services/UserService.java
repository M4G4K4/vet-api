package com.pedro.services;

import com.pedro.models.dto.user.UserCreate;
import com.pedro.models.dto.user.UserList;
import com.pedro.models.dto.user.UserRead;
import com.pedro.models.entity.User;
import com.pedro.models.mapper.UserMapper;
import com.pedro.utilities.UserFilter;
import com.pedro.utils.exception.ErrorCode;
import com.pedro.utils.exception.ServiceException;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {

    @Inject
    protected UserMapper mapper;

    @Transactional
    public UserRead createUser(final UserCreate userCreate) {

        User.findByNif(userCreate.getNif()).ifPresent(exception -> {
            throw new ServiceException(ErrorCode.USER_CC_ALREADY_EXISTS);
        });
        User.findByEmail(userCreate.getEmail()).ifPresent(exception -> {
            throw new ServiceException(ErrorCode.USER_EMAIL_ALREADY_EXISTS);
        });
        User.findByCardIdentification(userCreate.getCardIdentification()).ifPresent(exception -> {
            throw new ServiceException(ErrorCode.USER_CC_ALREADY_EXISTS);
        });

        final User user = mapper.userCreateToUser(userCreate);

        user.persist();

        return mapper.userToUserRead(user);
    }

    public UserRead getUser(final String userId) {

        final User user = User.findById(userId).orElseThrow(() -> new ServiceException(ErrorCode.USER_NOT_FOUND));

        return mapper.userToUserRead(user);
    }

    public UserList getUsers(final UserFilter userFilter) {
        final PanacheQuery<User> users = User.find(userFilter.buildQuery(), userFilter.buildParameters())
                .page(userFilter.getPage() - 1, userFilter.getPerPage());

        final List<UserRead> userList = users.stream().map(mapper::userToUserRead).collect(Collectors.toList());

        return UserList.builder()
                .page(userFilter.getPage())
                .perPage(userFilter.getPerPage())
                .total(users.count())
                .count(userList.size())
                .totalPages(users.pageCount())
                .users(userList)
                .build();
    }
}
