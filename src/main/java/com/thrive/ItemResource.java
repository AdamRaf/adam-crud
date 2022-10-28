package com.thrive;

import io.quarkus.vertx.ConsumeEvent;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject
    ItemService itemService;

    @GET
    public List<Item> get(){
        return itemService.get();
    }

    @POST
    public void create(Item item){
        itemService.create(item);
    }

    @PUT
    public void update(Item item){
        itemService.update(item);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id){
        itemService.delete(id);
    }
}
