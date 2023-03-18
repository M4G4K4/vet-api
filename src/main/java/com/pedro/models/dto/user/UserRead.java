package com.pedro.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRead {

    private String id;

    private String firstName;

    private String lastName;

    private String fullName;
}
