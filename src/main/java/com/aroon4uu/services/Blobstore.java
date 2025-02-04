package com.aroon4uu.services;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class Blobstore {
	
	private static BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService(); 
	
	private static Blobstore instance;
	
	public Blobstore getInstance() {
		if(instance==null) {
			instance = new Blobstore();
		}
		return instance;
	}
	
}
