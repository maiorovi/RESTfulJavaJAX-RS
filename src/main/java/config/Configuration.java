package config;

import resource.AddressableCustomerResource;
import resource.CarResource;
import resource.CustomerResourceImpl;
import resource.FileResource;
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
		singletons.add(new CarResource());
		singletons.add(new FileResource());
		singletons.add(new AddressableCustomerResource());
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
