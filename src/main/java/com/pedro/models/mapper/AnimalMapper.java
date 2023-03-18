package com.pedro.models.mapper;

import com.pedro.models.dto.animal.AnimalCreate;
import com.pedro.models.dto.animal.AnimalRead;
import com.pedro.models.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnimalMapper {

    AnimalRead animalToAnimalRead(Animal animal);

    Animal animalCreateToAnimal(AnimalCreate animalCreate);
}
