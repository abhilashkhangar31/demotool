package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectionController {

	@GetMapping
	protected String homePage() {
		return "home";
	}
	
	@GetMapping(value = "/welcome")
	protected String welcomePage() {
		return "welcome";
	}
	
	@GetMapping(value = "/admin")
	protected String adminPage() {
		return "admin";
	}
	
	@GetMapping(value = "/accessDenied")
	protected String accessDeniedPage() {
		return "accessDenied";
	}
}
