package com.andrey.spring.demo.services;

import java.util.List;
import com.andrey.spring.demo.models.Greeting;

public interface GreetingService {
	
	List<Greeting> getAllMessages();
	Greeting getMessageById(String id);
	void createGreeting(Greeting greeting);
}
