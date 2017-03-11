package org.kottu.birdapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kottu.birdapp.model.BirdSightings;
import org.kottu.birdapp.model.Birds;
import org.kottu.birdapp.service.BirdService;
import org.kottu.birdapp.service.BirdSightingsService;

@Path("/birds")
public class BirdResource {


	BirdService BSService = new BirdService();
	BirdSightingsService BBSIService = new BirdSightingsService();
	
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchBirdDets(@QueryParam("SearchDets") String SearchDets) {
		if(SearchDets == null || SearchDets.trim().length() == 0) {
	        return Response.serverError().entity("SearchParams cannot be blank").build();
	    }
		
		String[] resp =  BSService.searchBirdDetails(SearchDets);
		if(resp[0].equals("SUCC"))
		    return Response.ok(resp[1], MediaType.APPLICATION_JSON).build();
		else if(resp[0].equals("ERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		else if(resp[0].equals("FERR"))
			return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();  
		
		return Response.status(Response.Status.BAD_REQUEST).entity("There was an error pls try again").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertBird(Birds bird) {
		if(bird == null) {
	        return Response.serverError().entity("UserDetails not given").build();
	    }
		String[] resp =  BSService.insertBirds(bird);
		if(resp[0].equals("SUCC"))
		    return Response.ok(resp[1], MediaType.APPLICATION_JSON).build();
		else if(resp[0].equals("ERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		else if(resp[0].equals("FERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		
		return Response.status(Response.Status.BAD_REQUEST).entity("There was an error").build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertSigting(BirdSightings birdSighting) {
		if(birdSighting == null) {
	        return Response.serverError().entity("Sighting details not given").build();
	    }
		
		String[] resp =  BBSIService.insertBirdSight(birdSighting);
		if(resp[0].equals("SUCC"))
		    return Response.ok(resp[1], MediaType.APPLICATION_JSON).build();
		else if(resp[0].equals("ERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		else if(resp[0].equals("FERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		
		return Response.status(Response.Status.BAD_REQUEST).entity("There was an error").build();
	}

	
}
