package com.pedro.resources;

import com.pedro.models.dto.user.UserCreate;
import com.pedro.models.entity.Animal;
import com.pedro.models.entity.User;
import com.pedro.services.UserService;
import com.pedro.utilities.AnimalFilter;
import com.pedro.utilities.UserFilter;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService service;

    @POST
    public Response createUser(@Valid final UserCreate userCreate) {
        return Response.ok(service.createUser(userCreate)).build();
    }

    @GET
    public Response getUsers(@BeanParam final UserFilter userFilter){
        return Response.ok(service.getUsers(userFilter)).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") final String id){
        return Response.ok(service.getUser(id)).build();
    }

}