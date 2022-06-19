package com.pedro.resources;

import com.pedro.models.dto.user.UserCreate;
import com.pedro.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Response createUser(final UserCreate userCreate) {
        return Response.ok(service.createUser(userCreate)).build();
    }
}