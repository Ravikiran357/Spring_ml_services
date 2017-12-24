 package com.ravikiran357.basic_ml_services.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class SmtpSendMail implements MailSender {

	private static Log log = LogFactory.getLog(SmtpSendMail.class);
	
	@Override
	public void send(String to, String subject, String body) {
		// TODO Auto-generated method stub
		log.info("Sending SMTP mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
	}
	
}
