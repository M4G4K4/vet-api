package com.pedro.models.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserListItem {

    private String name;

    private String identification;
}
