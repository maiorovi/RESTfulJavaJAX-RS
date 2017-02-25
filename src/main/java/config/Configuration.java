package config;

import resource.CustomerResource;
import test.MessageRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class Configuration extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	public Configuration() {
		singletons.add(new CustomerResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MessageRestService.class);
//		classes.add(CustomerResource.class);

		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
