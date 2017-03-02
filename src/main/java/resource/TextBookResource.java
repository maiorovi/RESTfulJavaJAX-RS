package resource;

import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/textbook")
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
}
