package com.pedro.resources;

import com.pedro.utilities.AnimalFilter;
import com.pedro.utilities.Filter;
import com.pedro.models.dto.animal.AnimalCreate;
import com.pedro.services.AnimalService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/animal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalResource {

    @Inject
    AnimalService service;

    @POST
    public Response createAnimal(@Valid @NotNull final AnimalCreate animalCreate) {
        return Response.ok(service.createAnimal(animalCreate)).build();
    }

    @GET
    @Path("/{animal_id}")
    public Response getAnimalById(@PathParam("animal_id") final String id){
        return Response.ok(service.getAnimalById(id)).build();
    }

    @GET
    public Response getAnimals(@BeanParam final AnimalFilter animalFilter){
        return Response.ok(service.getAnimals(animalFilter)).build();
    }
}
