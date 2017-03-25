package resource;

import domain.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.concurrent.ConcurrentHashMap;

@Path("/watches")
@Component
public class WatchesSecuredResource {
	private ConcurrentHashMap<Long, Watch> watches = new ConcurrentHashMap<>();
	@Autowired
	@Qualifier("test")
	private String test;

	@Autowired
	@Qualifier("test1")
	private String test1;

	@GET
	@Produces("application/json")
	public Response retrieveWatches() {
		System.out.println(">>>: " + test);
		System.out.println(">>>: " + test1);

		watches.put(1l, new Watch(1l, "Swatch"));

		return Response.ok(watches.values()).build();
	}
}
