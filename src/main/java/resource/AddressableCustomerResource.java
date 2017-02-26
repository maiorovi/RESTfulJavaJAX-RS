package resource;

import domain.AddressableCustomer;
import domain.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/addressable-customer")
public class AddressableCustomerResource {

	private ConcurrentHashMap dataStore = new ConcurrentHashMap();
	private AtomicInteger atomicInteger = new AtomicInteger();

	@POST
	@Consumes("application/xml")
	public Response addCustomer(AddressableCustomer customer) throws URISyntaxException {

		System.out.println(customer);
		customer.setId(atomicInteger.getAndIncrement());
		dataStore.put(customer.getId(), customer);

		return Response.created(new URI("addressable-customer/"+ customer.getId())).build();
	}

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public Response getCustomer(@PathParam("id") int id) {
		if (!dataStore.containsKey(id)) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return Response.ok().entity(dataStore.get(id)).build();
	}



}
