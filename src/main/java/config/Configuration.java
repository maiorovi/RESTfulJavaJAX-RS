package config;

import resource.CustomerResourceImpl;
import test.MessageRestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class Configuration extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	public Configuration() {
		singletons.add(new CustomerResourceImpl());
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(MessageRestService.class);
//		classes.add(CustomerResourceImpl.class);

		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
