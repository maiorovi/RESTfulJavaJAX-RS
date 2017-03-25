package resource;

import exceptions.EntityNotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.ws.rs.*;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/textbook")
@Component
public class TextBookResource {

	@GET
	@Path("restfuljava")
	@Produces("text/plain")
	public Response getBook() {
		String book = "Alice in Wonderland";

		Response.ResponseBuilder builder = Response.ok(book);
		builder.language("eng")
				.header("Some-header", "header value");


		return builder.build();
	}


	@GET
	@Path("cookies")
	public Response getWithCookies() {
		NewCookie cookie = new NewCookie("key", "value");
		Response.ResponseBuilder responseBuilder = Response.ok("hello", "text/plain");

		return responseBuilder.cookie(cookie).build();
	}

	@GET
	@Path("not_found")
	public Response withException() {
		throw new WebApplicationException("Not found", Response.status(Response.Status.NOT_FOUND).entity("not_found").build());
	}


	@GET
	@Path("not_found_with_mapper")
	public Response notFoundWithMapper() {
		throw new EntityNotFoundException();
	}

	@GET
	@Path("not_found_with_specific_exception")
	public Response notFoundWithSpecificException() {
		throw new NotFoundException("not found", Response.status(Response.Status.NOT_FOUND).entity("non found with specific exception").build());
	}
}
