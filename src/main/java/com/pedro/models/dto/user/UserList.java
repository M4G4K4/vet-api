package com.pedro.models.dto.user;

import com.pedro.models.dto.Page;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class UserList extends Page {

    private final List<UserListItem> users;

    @Builder
    public UserList(final int perPage, final int page, final long total, final long count, final List<UserListItem> users) {
        super(page, perPage, total, count);
        this.users = users;
    }
}
