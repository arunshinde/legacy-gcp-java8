package com.aroon4uu.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.storage.Storage;
import com.google.api.services.storage.StorageScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

public class StorageService {
	private static StorageService instance;
	
	private Storage storage;
	
	public StorageService getInstance() {
		if(instance==null) {
			instance = new StorageService();
		}
		return instance;
	}
	
	public Storage initStorageService() throws GeneralSecurityException, IOException {
		if(storage!=null) {
			return storage;
		}
		Collection<String> storageScopes = Arrays.asList(StorageScopes.DEVSTORAGE_FULL_CONTROL);
		
		GoogleCredentials googleCredential = GoogleCredentials.getApplicationDefault();
		if(googleCredential.createScopedRequired()) {
			googleCredential = googleCredential.createScoped(storageScopes);
		}
		HttpRequestInitializer httpRequestInitializer = new HttpCredentialsAdapter(googleCredential);
		storage = new Storage.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), httpRequestInitializer)
					.setApplicationName("TestApplication").build();
		return storage;
	}
}
