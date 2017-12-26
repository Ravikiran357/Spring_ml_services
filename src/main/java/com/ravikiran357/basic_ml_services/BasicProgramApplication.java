package com.ravikiran357.basic_ml_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation results in this package and all subpackages being scanned for other annotations, such classes
// with those anotations will be used to create beans which get stored in the ApplicationContext. If some other 
// package needs to be scanned apart from "basic_ml_services", we can pass "scanBasePackageClasses" attribute and
// pass a list of classes. Here the package having Abc class will be scanned alongwith the subpackages 
// @SpringBootApplication(scanBasePackageClasses = (BasicProgramApplication.class,Abc.class))
@SpringBootApplication
public class BasicProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicProgramApplication.class, args);
	}
}
