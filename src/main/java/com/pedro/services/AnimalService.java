package com.pedro.services;

import com.pedro.models.dto.animal.AnimalCreate;
import com.pedro.models.dto.animal.AnimalList;
import com.pedro.models.dto.animal.AnimalRead;
import com.pedro.models.entity.Animal;
import com.pedro.models.entity.User;
import com.pedro.models.mapper.AnimalMapper;
import com.pedro.utilities.AnimalFilter;
import com.pedro.utils.exception.ErrorCode;
import com.pedro.utils.exception.ServiceException;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class AnimalService {

    @Inject
    protected AnimalMapper mapper;

    @Transactional
    public AnimalRead createAnimal(final AnimalCreate animalCreate) {
        final Optional<User> userOptional = User.findByIdOptional(Long.parseLong(animalCreate.getOwnerId()));

        final User user = userOptional.orElseThrow(() -> new ServiceException(ErrorCode.USER_NOT_FOUND));

        final Animal animal = Animal.builder()
                .name(animalCreate.getName())
                .type(animalCreate.getType().name())
                .owner(user)
                .sex(animalCreate.getSex().name())
                .build();

        animal.persist();

        return mapper.animalToAnimalRead(animal);
    }

    public AnimalRead getAnimalById(final String id) {
        final Animal animal = Animal.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.ANIMAL_NOT_FOUND));

        return mapper.animalToAnimalRead(animal);
    }


    public AnimalList getAnimals(final AnimalFilter animalFilter) {
        final PanacheQuery<Animal> animals = Animal.find(animalFilter.buildQuery(), animalFilter.buildParameters())
                .page(animalFilter.getPage() - 1, animalFilter.getPerPage());

        /*
        final List<AnimalListItem> animalListItems = animals.list().stream()
                .map(mapper::animalListToAnimalListItem)
                .collect(Collectors.toList());


        return AnimalList.builder()
                .perPage(animalFilter.getPerPage())
                .page(animalFilter.getPage())
                .count(animalListItems.size())
                .total(Animal.count(animalFilter.buildQuery(), animalFilter.buildParameters()))
                .animalListItems(animalListItems)
                .build();

         */
        return AnimalList.builder().build();
    }
}
