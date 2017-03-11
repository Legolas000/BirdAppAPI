package org.sgit.birdapp.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/birds")
public class BirdResource {

	//Get userprofile details
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsrProfile() {
			String[] resp =  UService.getUsrProfile(UserName);
			if(resp[0].equals("SUCC"))
				return Response.status(Response.Status.OK).entity(resp[1]).build();
			else if(resp[0].equals("EMPARR"))
				return Response.status(Response.Status.BAD_REQUEST).entity(MsgConsts.DetsNFound).build();
			else if(resp[0].equals("FERR"))
				return Response.status(Response.Status.BAD_REQUEST).entity(MsgConsts.FuncExErr).build();
			
			return Response.status(Response.Status.BAD_REQUEST).entity(MsgConsts.UnkError).build();
		}
	}
	
}
