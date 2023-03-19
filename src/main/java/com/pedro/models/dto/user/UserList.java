package com.pedro.models.dto.user;

import com.pedro.models.dto.Page;
import com.pedro.models.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserList extends Page {

    private List<UserRead> users;

    @Builder
    public UserList(final int page, final int perPage, final long total, final long count, final long totalPages, final List<UserRead> users) {
        super(page, perPage, total, count, totalPages);
        this.users = users;
    }
}
