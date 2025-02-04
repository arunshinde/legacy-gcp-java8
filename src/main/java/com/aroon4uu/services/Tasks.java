package com.aroon4uu.services;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;

public class Tasks {
	private static Tasks instance;
	
	public Tasks getInstance() {
		if(instance==null) {
			instance = new Tasks();
		}
		return instance;
	}
	
	public static void testQueueExecution(String queueName) {
		Queue queue = QueueFactory.getQueue(queueName);
	}
}
