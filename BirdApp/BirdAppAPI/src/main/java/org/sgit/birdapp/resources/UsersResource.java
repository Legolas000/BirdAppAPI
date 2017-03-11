package org.sgit.birdapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sgit.birdapp.model.Users;
import org.sgit.birdapp.service.UserService;

@Path("/users")
public class UsersResource {

	UserService USService = new UserService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertUser(Users user) {
		if(user == null) {
	        return Response.serverError().entity("UserDetails not given").build();
	    }
		String[] resp =  USService.insertUsers(user);
		if(resp[0].equals("SUCC"))
		    return Response.ok(resp[1], MediaType.APPLICATION_JSON).build();
		else if(resp[0].equals("ERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		else if(resp[0].equals("FERR"))
		       return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
		
		return Response.status(Response.Status.BAD_REQUEST).entity("There was an error").build();
	}
	
	
	@Path("/login")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(Users user) {
		if(user == null)
			return Response.serverError().entity("The login details are empty").build();
		else if(user.getEmail() == null || user.getPassword() == null)
			return Response.status(Response.Status.BAD_REQUEST).entity("The user email or the password is missing").build();
		else{
			String[] resp =  USService.loginUser(user);
			if(resp[0].equals("SUCC"))
				return Response.status(Response.Status.OK).entity(resp[1]).build();
			else if(resp[0].equals("ACTERR"))
				return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
			else if(resp[0].equals("ERR"))
				return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
			else if(resp[0].equals("FERR"))
				return Response.status(Response.Status.BAD_REQUEST).entity(resp[1]).build();
			
			return Response.status(Response.Status.BAD_REQUEST).entity("An error occured pls try again").build();
		}
	}
	
}
