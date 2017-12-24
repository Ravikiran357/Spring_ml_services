package com.ravikiran357.basic_ml_services.mail;

public interface MailSender {

	void send(String to, String subject, String body);
}
