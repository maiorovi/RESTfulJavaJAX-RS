package resource;

import domain.Capital;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

public class CapitalResourceTest {


	@Test
	public void getTest() throws Exception {
		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
		POJOResourceFactory noDefaults = new POJOResourceFactory(CapitalResource.class);
		dispatcher.getRegistry().addResourceFactory(noDefaults);


		MockHttpRequest request = MockHttpRequest.get("/capital/1");
		MockHttpResponse response = new MockHttpResponse();

		dispatcher.invoke(request, response);

		assertThat(response.getStatus()).isEqualTo(404);
	}

	@Test
	public void addsCapital() throws Exception {
		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
		POJOResourceFactory noDefaults = new POJOResourceFactory(CapitalResource.class);
		dispatcher.getRegistry().addResourceFactory(noDefaults);

		String capital = "<capital><id>3</id><name>Kiev</name><population>3</population></capital>";

		MockHttpRequest request = MockHttpRequest.post("/capital")
				.content(capital.getBytes())
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_XML);

		MockHttpResponse response = new MockHttpResponse();

		dispatcher.invoke(request, response);

		assertThat(response.getStatus()).isEqualTo(201);
		assertThat(response.getOutputHeaders().get("Location").get(0)).isEqualTo(new URI("/capital/1"));
	}
}
