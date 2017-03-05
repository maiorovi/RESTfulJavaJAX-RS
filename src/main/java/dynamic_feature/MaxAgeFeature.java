package dynamic_feature;

import annotations.MaxAge;
import filters.CacheControlFilter;
import org.jboss.resteasy.plugins.interceptors.CacheControlFeature;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class MaxAgeFeature implements DynamicFeature {
	@Override
	public void configure(ResourceInfo resourceInfo, FeatureContext context) {
		MaxAge max = resourceInfo.getResourceMethod().getAnnotation(MaxAge.class);
		if (max == null) {
			max = resourceInfo.getResourceClass().getAnnotation(MaxAge.class);
			if (max == null) return;
			CacheControlFilter filter = new CacheControlFilter(max.value());
			context.register(filter);
		} else {
			CacheControlFilter filter = new CacheControlFilter(max.value());
			context.register(filter);
		}
	}
}
