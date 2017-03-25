package resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.io.*;

@Path("/file")
@Component
public class FileResource {

	private static final String basePath = "F:\\projects\\RESTfulJavaJAXRS\\src\\main\\resources";

	@GET
	@Path("/{filepath: .*}")
	@Produces("text/plain")
	public File getFile(@PathParam("filepath") String filePath) {
		System.out.println(filePath);
		return new File(basePath + "\\" +filePath);
	}

}
