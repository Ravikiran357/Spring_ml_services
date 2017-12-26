package com.ravikiran357.basic_ml_services.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravikiran357.basic_ml_services.mail.MailSender;

// the spring application looks for meta-data which are these annotations- due to "restcontroller",
// in the application context a MailController isntance will be created
@RestController
public class MailController {
	
//  when the MailController instance is created, Spring application will see the "autowired", 
//	the spring application looks in the application-context for a "component" 
//	and assigns this reference here - to this interface MailSender 
//	These instances due to "restcontroller", "component" are also called beans which are stored in the 
//	application context. When creating these instances it also looks at the member variables (like MailSender) or methods
//	for the annotations, if any (like autowired), then Spring application injects into those member variables 
//	(for eg. mailSender being member variable for MailController bean - based on same type or inheritance/implements) 
//	the references from the Application context 
	
//	3 ways to initialize the mailSender using a "Component" bean
	
//	If both SendMail and SmtpSendMail have "component" then this causes compiler error - unresolved bean for the MailSender
//	There are many ways to resolve the bean, one is to replace mailSender variable with camelCase of required class 
//	(like sendMail)
	
//	@Autowired
	private MailSender mailSender;
//	private MailSender mailSender = new SendMail(); // issue is it needs code change 
//  if SmtpSendMail needs to be used instead, so dependency injection can help here
	
//	@Autowired
//	public void setMailSender(MailSender mailSender) {
//		this.mailSender = mailSender;
//	}

//	@Autowired // Not required with only one constructor
// We can use the Component class in camel case as variable parameter for MailController constructor to inject 
// to MailSender. If a name (like "smtp") is provided to the component bean, then that can be used as variable 
//	to get that class instance to be injected into the MailSender. 
//	public MailController(@Qualifier("smtpMail") MailSender smtp) {
//	public MailController(MailSender sendMail) {
	public MailController(MailSender s) {
		this.mailSender = s;
	}
	
	
	@RequestMapping("/mail")
	public String hello() throws MessagingException {
		
		// here mail is being sent synchronously, need to use separate thread to send mail asynchronously
		mailSender.send("soccer.ravi@gmail.com", "Test Mock subject", "test body");
		
		return "mail sent";
	}
}
