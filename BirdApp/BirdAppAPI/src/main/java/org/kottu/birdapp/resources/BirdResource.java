package org.kottu.birdapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kottu.birdapp.service.BirdService;

@Path("/birds")
public class BirdResource {


	BirdService BSService = new BirdService();
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBirdDetails() {
		String[] resp =  BSService.getBirdDetails();
		if(resp[0].equals("SUCC"))
			return Response.status(Response.Status.OK).entity(resp[1]).build();
		else if(resp[0].equals("EMPARR"))
			return Response.status(Response.Status.BAD_REQUEST).entity(resp[0]).build();
		else if(resp[0].equals("FERR"))
			return Response.status(Response.Status.BAD_REQUEST).entity(resp[0]).build();
		
		return Response.status(Response.Status.BAD_REQUEST).entity("An error occured pls try again").build();
	}

	
}
