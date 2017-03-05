package resource;

import annotations.MaxAge;
import domain.Capital;
import org.apache.http.client.methods.RequestBuilder;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/capital")
@MaxAge(900)
public class CapitalResource {
	private ConcurrentHashMap<Integer, Capital> capitalsStore = new ConcurrentHashMap<>();
	private AtomicInteger counter = new AtomicInteger();

	@GET
	@Path("{id}")
	@Produces("application/xml")
	@MaxAge(700)
	public Response getCapital(@PathParam("id") int id, @Context Request request) {
		Capital capital = capitalsStore.get(id);

		if (capital == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		EntityTag etag = new EntityTag(Integer.valueOf(capital.hashCode()).toString());

		CacheControl cacheControl = new CacheControl();
		cacheControl.setPrivate(true);
		cacheControl.setMaxAge(300);

		Response.ResponseBuilder builder = request.evaluatePreconditions(etag);

		if (builder != null) {
			//not-modified
			return builder.tag(etag).cacheControl(cacheControl).build();
		}

		return Response.ok().entity(capital).cacheControl(cacheControl).tag(etag).build();
	}

	@GET
	@Produces("application/json")
	public Response getCapitals() {
		List<Capital> capitals = new ArrayList<>();
		capitalsStore.values().forEach(it -> capitals.add(it));
		return Response.ok().entity(capitals).build();
	}

	@POST
	public Response addCapital(Capital capital) throws URISyntaxException {
		capital.setId(counter.incrementAndGet());

		capitalsStore.put(capital.getId(), capital);

		return Response.created(new URI("/capital/" + capital.getId())).build();
	}

	@PUT
	@Path("{id}")
	public Response updateCapital(Capital capital, @Context Request request) {
		Capital currentCapital = capitalsStore.get(capital.getId());

		if (currentCapital == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(300);

		EntityTag eTag = new EntityTag(Integer.valueOf(capital.hashCode()).toString());

		Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(eTag);

		if (responseBuilder != null) {
			//precondition not met
			return responseBuilder.cacheControl(cacheControl).build();
		}

		return Response.noContent().build();
	}
}
