package com.pedro.models.dto.animal;

import com.pedro.models.dto.Page;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AnimalList extends Page {

    private final List<AnimalListItem> animals;

    @Builder
    public AnimalList(final int perPage, final int page,final long total, final long count, final List<AnimalListItem> animalListItems) {
        super(page, perPage, total, count);
        this.animals = animalListItems;
    }

}
