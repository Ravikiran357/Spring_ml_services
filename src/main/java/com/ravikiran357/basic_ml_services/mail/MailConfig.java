package com.ravikiran357.basic_ml_services.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

// Suppose we have a jar of some library. This will have only byte code and the original code wouldn't have 
// used annotations like @Component, @Service, etc, but still if the classes in the jar are known then they can be 
// configured using a configuration class. Here we commented out all annotations in the classes in "mail" package

// We can also use Component instead of Configuration, but this is not advisable as there is some diff
// Another option is to use XML configuration, but java is preferred
@Configuration
//@Component
public class MailConfig {
	
	@Bean
	public DemoBean demoBean() {
		return new DemoBean(); 
	}
	
// These beans will get stored in the application context, names of the beans will be the method names	
	@Bean
//	@Profile("dev")
	@ConditionalOnProperty(name="spring.mail.host", havingValue="foo", matchIfMissing=true)
	public MailSender sendMail() {
		return new SendMail();
	}
	
	@Bean
//	@Profile("!dev") // prod or test env
	@ConditionalOnProperty("spring.mail.host") // Conditional properties to help choose configs for the application context
//	public MailSender smtpSendMail(JavaMailSender javaMailSender, DemoBean demoBean) {
	public MailSender smtpSendMail(JavaMailSender javaMailSender) {
		demoBean();
		return new SmtpSendMail(javaMailSender);
	}
}
