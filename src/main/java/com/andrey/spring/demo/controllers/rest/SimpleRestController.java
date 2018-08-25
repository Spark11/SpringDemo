package com.andrey.spring.demo.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andrey.spring.demo.models.Greeting;
import com.andrey.spring.demo.services.GreetingService;
import com.google.gson.Gson;

@RestController
public class SimpleRestController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public ResponseEntity<String> getAllGreetings() {
		List<Greeting> greetings = greetingService.getAllMessages();
		Gson gson = new Gson();
		String json = gson.toJson(greetings);
		ResponseEntity<String> response = new ResponseEntity<String>(json, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/greetings/{greetingId}", method = RequestMethod.GET)
	public ResponseEntity<String> getGreetingById(@PathVariable(name = "greetingId") String greetingId) {
		Greeting greeting = greetingService.getMessageById(greetingId);
		ResponseEntity<String> response = null;

		if (greeting != null) {
			Gson gson = new Gson();
			String json = gson.toJson(greeting);
			response = new ResponseEntity<String>(json, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Error 404. Greeting not found.", HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@RequestMapping(value = "/greetings/create", method = RequestMethod.POST)
	public ResponseEntity<String> createGreeting(@RequestBody(required = true) String greetingJson) {
		Gson gson = new Gson();
		greetingService.createGreeting(gson.fromJson(greetingJson, Greeting.class));
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
