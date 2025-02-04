package com.aroon4uu.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.bigquery.Bigquery;
import com.google.api.services.bigquery.BigqueryScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

public class BigQuery {
	private static BigQuery instance;
	
	private static Bigquery bigquery;
	
	public BigQuery getInstance() {
		if(instance==null) {
			instance = new BigQuery();
		}
		return instance;
	}
	
	public Bigquery initBigQueryService() throws IOException, GeneralSecurityException {
		if(bigquery!=null) {
			return bigquery;
		}
		Collection<String> bigqueryScopes = Arrays.asList(BigqueryScopes.BIGQUERY, BigqueryScopes.BIGQUERY_INSERTDATA);
		
		GoogleCredentials googleCredential = GoogleCredentials.getApplicationDefault();
		if(googleCredential.createScopedRequired()) {
			googleCredential = googleCredential.createScoped(bigqueryScopes);
		}
		HttpRequestInitializer httpRequestInitializer = new HttpCredentialsAdapter(googleCredential);
		bigquery = new Bigquery.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), httpRequestInitializer)
					.setApplicationName("TestApplication").build();
		return bigquery;
	}
}
