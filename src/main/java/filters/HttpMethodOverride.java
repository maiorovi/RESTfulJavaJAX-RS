package filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class HttpMethodOverride implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String methodOverride = requestContext.getHeaderString("X-Http-Method-Override");
		if (methodOverride != null) requestContext.setMethod(methodOverride);
	}
}
