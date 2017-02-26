package resource;

import custom_utils.LOCK;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;

@Path("/customers")
public interface CustomerResource {

	@POST
	@Consumes("application/xml")
	Response createCustomer(InputStream is);

	@GET
	@Path("{firstname}-{lastname}")
	@Produces("application/xml")
	Response getCustomerByFullName(@PathParam("firstname") String first,
	                               @PathParam("lastname") @DefaultValue("2") String last);

	@GET
	@Path("{id: \\d+}")
	@Produces("application/xml")
	StreamingOutput getCustomer(@PathParam("id") int id,
	                            @HeaderParam("User-Agent") String userAgent,
	                            @CookieParam("last-visit") String date);

	@PUT
	@Path("{id: \\d+}")
	@Consumes("application/xml")
	void updateCustomer(@PathParam("id") int id, InputStream is);

	@LOCK
	@Path("hello-lock")
	Response lockAnnotation();

	//forbiden params in url
	@GET
	@Path("roy&fielding")
	public Response getOurBestCustomer();
}
