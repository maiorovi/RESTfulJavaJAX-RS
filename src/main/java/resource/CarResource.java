package resource;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/cars")
public class CarResource {

	public static enum Color {
		red,
		white,
		blue,
		black
	}

	@GET
	@Path("/matrix/{make}/{model}/{year}")
	@Produces("text/plain")
	public String getFromMatrixParam(
			@PathParam("make") String make,
	        @PathParam("model") PathSegment car,
	        @MatrixParam("color") Color color,
			@PathParam("year") String year) {
		return "A " + color + " " + year + " " + make + " " + car.getPath();
	}


	@GET
	@Path("/segment/{make}/{model}/{year}")
	@Produces("text/plain")
	public String getFromPathSegment(@PathParam("make") String make,
	                                 @PathParam("model") PathSegment car,
	                                 @PathParam("year") String year) {
		String carColor = car.getMatrixParameters().getFirst("color");

		return "A " + carColor + " " + year + " " + make + " " + car.getPath();
	}

	@GET
	@Path("/segments/{make}/{model : .+}/{year}")
	public String getFromMultipleSegments(@PathParam("make") String make,
	                                      @PathParam("model")List<PathSegment> car,
	                                      @PathParam("year")String year) {
		String output = "A " + year + " " + make;

		for (PathSegment segment : car) {
			output += " " + segment.getPath();
		}

		return output;
	}

	@GET
	@Path("/uriinfo/{make}/{model}/{year}")
	public String getFromUriInfo(@Context UriInfo uriInfo) {
		String make = uriInfo.getPathParameters().getFirst("make");
		PathSegment model = uriInfo.getPathSegments().get(3);
		String color = model.getMatrixParameters().getFirst("color");
		String year = uriInfo.getPathParameters().getFirst("year");

		return "A" + color + " " + year + " " + make + " " + model.getPath();
	}
}
