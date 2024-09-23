package io.dvkdo.eslcoord;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/instructor")
public class InstructorResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveInstructors(String jsonString){
        
    }

    @GET
    @Path("/particles")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllParticles() {
        return ParticleEntity.listAll().toString();
    }

    @Transactional
    @POST
    @Path("/particle/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String addParticles(@PathParam("name") String name) {

        ParticleEntity particleEntity = new ParticleEntity();
        particleEntity.name = name;
        particleEntity.persist();
        return particleEntity.toString();
    }

}
