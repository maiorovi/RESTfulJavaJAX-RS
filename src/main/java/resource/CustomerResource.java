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
	                               @PathParam("lastname") String last);

	@GET
	@Path("{id: \\d+}")
	@Produces("application/xml")
	StreamingOutput getCustomer(@PathParam("id") int id);

	@PUT
	@Path("{id: \\d+}")
	@Consumes("application/xml")
	void updateCustomer(@PathParam("id") int id, InputStream is);

	@LOCK
	@Path("hello-lock")
	Response lockAnnotation();
}
