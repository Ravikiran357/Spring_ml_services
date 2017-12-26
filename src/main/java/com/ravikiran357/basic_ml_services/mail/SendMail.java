 package com.ravikiran357.basic_ml_services.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Creates an instance of the SendMail class and stores in the ApplicationContext,
// this object can be used for any autowiring like in a controller class
//@Component
//@Primary // This is given preference in the bean injection during autowiring 
//@Component("mock")
public class SendMail implements MailSender {

	private static Log log = LogFactory.getLog(SendMail.class);
	
	@Override
	public void send(String to, String subject, String body) {
		// TODO Auto-generated method stub
		log.info("Sending mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
	}
	
}
