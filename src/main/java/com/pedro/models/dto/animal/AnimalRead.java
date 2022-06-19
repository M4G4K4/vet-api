package com.pedro.models.dto.animal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalRead {
    private Long id;

    private String name;

    @JsonProperty("owner_name")
    private String ownerName;

    private String sex;
}
