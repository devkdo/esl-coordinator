package io.dvkdo.eslcoord;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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

}
