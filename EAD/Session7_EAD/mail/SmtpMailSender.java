package com.mailsender.mail;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("smtp")
@Primary
public class SmtpMailSender implements MailSender {
	
	@Override
	public void sendMail() {
		System.out.println("Mail is sending through SmtpMailSender");
	}
}
