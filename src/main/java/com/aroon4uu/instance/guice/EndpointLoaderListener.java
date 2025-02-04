package com.aroon4uu.instance.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class EndpointLoaderListener extends GuiceServletContextListener {

	  @Override
	  protected Injector getInjector() {
	    return Guice.createInjector(new EndpointLoaderModule());
	  }
	}

