package com.aroon4uu.endpoints.api;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.gson.JsonObject;

@Api(version = "v1", name = "testApi1")
public class TestEndpoint1 {
	
	private static final Logger logger = Logger.getLogger(TestEndpoint1.class.getName());

	@ApiMethod(name = "testMethod", httpMethod = HttpMethod.POST, path = "test-method1")
	public JsonObject testMethod(final JsonObject assignmentForm, HttpServletRequest req){
		logger.info("This is test endpoint1");
		return null;
	}
}
