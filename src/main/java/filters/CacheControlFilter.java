package filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.CacheControl;
import java.io.IOException;

public class CacheControlFilter implements ContainerResponseFilter {

	private int maxAge;

	public CacheControlFilter(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		if (requestContext.getMethod().equals("GET")) {
			CacheControl cc = new CacheControl();
			cc.setMaxAge(maxAge);
			responseContext.getHeaders().add("Cache-Control", cc);
		}
	}
}
