package config;

import exceptions.EntityNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class EntityNotFoundMapper implements ExceptionMapper<EntityNotFoundException> {

	public Response toResponse(EntityNotFoundException exception) {
		return Response.status(Response.Status.NOT_FOUND).entity("not found using mapper").build();
	}

}
