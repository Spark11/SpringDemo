package com.andrey.spring.demo.controllers.mvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome!");
		model.addObject("message", "Welcome to this SpringDemo.");
		model.setViewName("welcome");
		return model;		
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Admin Panel");
		model.addObject("message", "This is the Admin panel.");
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "DBA Panel");
		model.addObject("message", "This is the DBA panel.");
		model.setViewName("admin");
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";		
	}
}
