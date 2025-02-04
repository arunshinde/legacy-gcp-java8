package com.aroon4uu.endpoints.api;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.gson.JsonObject;

@Api(version = "v1", name = "testApi2")
public class TestEndpoint2 {
	private static final Logger logger = Logger.getLogger(TestEndpoint1.class.getName());

	@ApiMethod(name = "testMethod", httpMethod = HttpMethod.POST, path = "test-method2")
	public JsonObject testMethod(final JsonObject assignmentForm, HttpServletRequest req){
		logger.info("This is test endpoint2");
		return null;
	}
}
