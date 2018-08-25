package com.andrey.spring.demo.persistence;

import java.util.ArrayList;
import java.util.List;

import com.andrey.spring.demo.models.Greeting;

public class GreetingDatabase {
	private static GreetingDatabase instance;
	private List<Greeting> greetings;

	private GreetingDatabase() {
		super();
		greetings = new ArrayList<Greeting>();
		for(int i = 0 ; i < 10 ; i++) {
			greetings.add(new Greeting("name" + i, "hello" + i));
		}
	}
	
	public static GreetingDatabase getInstance() {
		if(instance == null) {
			instance = new GreetingDatabase();
		}
		return instance;		
	}
	
	public List<Greeting> getAllMessages(){
		return greetings;
	}
	
	public Greeting getMessageById(String id) {
		for(Greeting greeting :  greetings) {
			if(greeting.getGreetingId().equalsIgnoreCase(id))
				return greeting;
		}
		return null;
	}
}
