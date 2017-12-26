package com.ravikiran357.basic_ml_services.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	// Due to this Value annotation, the app.name from application.properties is injected into the appName variable
//	@Value("${app.name}")
	private String appName = "to remove if value is uncommented";
	

	@RequestMapping("/hello")
	public String hello() {
		return "hello world " + appName;
	}
}
