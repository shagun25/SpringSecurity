package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public")
public class HomeController {

	@GetMapping("/home")
	public String Home(){
		return "this is Home Page";
	}
	
	@GetMapping("/login")
	public String Login(){
		return "this is Login Page";
	}
	
	@GetMapping("/register")
	public String Register(){
		return "this is Register Page";
	}
}
