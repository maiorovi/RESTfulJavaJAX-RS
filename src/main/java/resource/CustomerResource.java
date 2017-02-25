package resource;

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
	@Path("{id}")
	@Produces("application/xml")
	StreamingOutput getCustomer(@PathParam("id") int id);

	@PUT
	@Path("{id}")
	@Consumes("application/xml")
	void updateCustomer(@PathParam("id") int id, InputStream is);
}
