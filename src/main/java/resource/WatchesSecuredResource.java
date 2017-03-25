package resource;

import domain.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.concurrent.ConcurrentHashMap;

@Path("/watches")
public class WatchesSecuredResource {
	private ConcurrentHashMap<Long, Watch> watches = new ConcurrentHashMap<>();

	@GET
	@Produces("application/json")
	public Response retrieveWatches() {
		watches.put(1l, new Watch(1l, "Swatch"));

		return Response.ok(watches.values()).build();
	}
}
