package resource;

import domain.AddressableCustomer;
import domain.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
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

	@POST
	@Consumes("application/json")
	public Response addCustomerFromJson(AddressableCustomer customer) throws URISyntaxException {

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

//		Date date = Date.from(LocalDateTime.of(2017, 03, 06, 17, 50, 00).atZone(ZoneId.systemDefault()).toInstant());
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(300);
		cacheControl.setPrivate(true);
		cacheControl.setNoStore(false);

		return Response
				.ok()
				.cacheControl(cacheControl)
//				.expires(date)
				.entity(dataStore.get(id))
				.build();
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getCustomerToJson(@PathParam("id") int id) {
		if (!dataStore.containsKey(id)) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return Response.ok().entity(dataStore.get(id)).build();
	}





}
