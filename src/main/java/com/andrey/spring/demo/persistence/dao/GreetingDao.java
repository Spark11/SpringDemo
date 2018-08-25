package com.andrey.spring.demo.persistence.dao;

import java.util.List;

import com.andrey.spring.demo.models.Greeting;

public interface GreetingDao {
	
	List<Greeting> getAllGreetings();
	Greeting getGreetingById(String id);
	void createGreeting(Greeting greeting);
	void deleteGreetingById(String id);
	void deleteAllGreetings();
}
