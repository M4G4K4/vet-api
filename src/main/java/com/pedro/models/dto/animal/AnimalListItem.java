package com.pedro.models.dto.animal;

import com.pedro.models.dto.user.UserRead;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimalListItem {

    private String id;

    private String name;

    private String sex;

    private String type;

    private UserRead user;
}
