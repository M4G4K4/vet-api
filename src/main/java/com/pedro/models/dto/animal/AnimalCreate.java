package com.pedro.models.dto.animal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalCreate {

    @NotNull
    private String name;

    @NotNull
    private AnimalType type;

    @NotNull
    private AnimalSex sex;

    @NotNull
    @JsonProperty("owner_id")
    private String ownerId;
}
