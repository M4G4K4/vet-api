package com.pedro.models.dto.animal;

import com.pedro.models.dto.Page;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class AnimalList extends Page {

    private List<AnimalListItem> animals;
}
