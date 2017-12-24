package com.ravikiran357.basic_ml_services.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
