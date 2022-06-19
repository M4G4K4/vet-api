package com.pedro.models.mapper;

import com.pedro.models.dto.animal.AnimalList;
import com.pedro.models.dto.animal.AnimalListItem;
import com.pedro.models.dto.animal.AnimalRead;
import com.pedro.models.dto.user.UserListItem;
import com.pedro.models.dto.user.UserRead;
import com.pedro.models.entity.Animal;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimalMapper {

    public AnimalRead animalToAnimalRead(Animal animal){
        return AnimalRead.builder()
                .id(animal.id)
                .name(animal.getName())
                .ownerName(animal.getOwner().getFullName())
                .sex(animal.getSex())
                .build();
    }

    public AnimalListItem animalListToAnimalListItem(Animal animal){
        return AnimalListItem.builder()
                .id(animal.id)
                .name(animal.getName())
                .sex(animal.getSex())
                .type(animal.getType())
                .user(UserListItem.builder()
                        .name(animal.getOwner().getFullName())
                        .identification(animal.getOwner().getCardIdentification())
                        .build())
                .build();
    }
}
