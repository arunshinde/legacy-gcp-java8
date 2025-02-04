package com.aroon4uu.services;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

public class Datastore {
	private static Datastore instance;
	
	private static DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
	
	public Datastore getInstance() {
		if(instance==null) {
			instance = new Datastore();
		}
		return instance;
	}
}
