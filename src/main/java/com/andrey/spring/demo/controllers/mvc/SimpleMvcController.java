package com.andrey.spring.demo.controllers.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andrey.spring.demo.models.Greeting;
import com.andrey.spring.demo.services.GreetingService;

@Controller
public class SimpleMvcController {

	@Autowired
	private GreetingService greetingService;

	@RequestMapping(value = "/mvc/greetings", method = RequestMethod.GET)
	public String getAllGreetings(Model model) {
		List<Greeting> greetings = greetingService.getAllMessages();
		model.addAttribute("greetings", greetings);
		return "greetings";
	}

	@RequestMapping(value = "/mvc/greetings/create", method = RequestMethod.GET)
	public String addGreetingGet() {
		return "create-greeting";
	}
	
	@RequestMapping(value = "/mvc/greetings/create", method = RequestMethod.POST)
	public String addGreetingPost(HttpServletRequest request) {
		Map<String, String[]> params = request.getParameterMap(); 
		String name = params.get("name")[0];
		String message = params.get("message")[0];
		Greeting greeting = new Greeting(message, name);
		greetingService.createGreeting(greeting);
		return "redirect:/mvc/greetings";	// redirects to request mapping, NOT pages
	}
}
