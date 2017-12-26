 package com.ravikiran357.basic_ml_services.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

//@Component
//@Component("smtp") // using this name, we can declare a variable of this name to inject this bean
//@Qualifier("smtpMail") // Alternatively, giving a qualifier helps to choose bean to be injected, this Qualifier annotation 
// also needs to be mentioned in the controller or where the interface variable is being declared. If this 
// qualifier is not used then the default qualifier is the classname in camel case; smtpSendMail
public class SmtpSendMail implements MailSender {

	private static Log log = LogFactory.getLog(SmtpSendMail.class);
	
	private JavaMailSender javaMailSender;
	
	public SmtpSendMail(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;		
	}
	
	@Override
	public void send(String to, String subject, String body) throws MessagingException {
		// TODO Auto-generated method stub
		log.info("Sending SMTP mail to " + to);
		log.info("with subject " + subject);
		log.info("and body " + body);
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message, true); // true for multipart message
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body, true); // true for html
		
		
		// use helper for additional functionality
		javaMailSender.send(message);
		
	}
	
}
