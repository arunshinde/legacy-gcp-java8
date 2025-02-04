package com.aroon4uu.instance.guice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aroon4uu.endpoints.api.TestEndpoint1;
import com.aroon4uu.endpoints.api.TestEndpoint2;
import com.google.api.server.spi.guice.EndpointsModule;
import com.google.common.collect.ImmutableList;

public class EndpointLoaderModule extends EndpointsModule {
	  @Override
	  public void configureServlets() {
	    super.configureServlets();

	    Map<String, String> apiController = new HashMap<>();
	    apiController.put("endpoints.projectId", "YOUR-PROJECT-ID");
	    apiController.put("endpoints.serviceName", "YOUR-PROJECT-ID.appspot.com");

	    bind(TestEndpoint1.class).toInstance(new TestEndpoint1());
	    configureEndpoints("/_ah/api/*", ImmutableList.copyOf(loadEndpoints()));
	  }
	  
	  private List<Class<? extends Object>> loadEndpoints(){
		  List<Class<? extends Object>> classes = new ArrayList<>();
		  classes.add(TestEndpoint1.class);
		  classes.add(TestEndpoint2.class);
		  return classes;
	  }
}
