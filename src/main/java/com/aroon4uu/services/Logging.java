package com.aroon4uu.services;

public class Logging {
	private static Logging instance;
	
	public Logging getInstance() {
		if(instance==null) {
			instance = new Logging();
		}
		return instance;
	}
}
