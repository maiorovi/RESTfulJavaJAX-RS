package filters;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Logger;

@Provider
@PreMatching
public class BearerTokenFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorization = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

//		if (authorization == null) {
//			throw new NotAuthorizedException("beared");
//		}

		String token = parseToken(authorization);

		if(!isTokenValid(token)) {
			throw new NotAuthorizedException("invalid token");
		}

		System.out.println("BearerTokenFilter filter is invoked!");

	}

	private String parseToken(String authHeader) {
		return "token";
	}

	private boolean isTokenValid(String token) {
		return true;
	}

}
