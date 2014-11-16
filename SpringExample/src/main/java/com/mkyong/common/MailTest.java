package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailTest {
	private MailSender mailSender;
	private SimpleMailMessage templateMessage;
	static ApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[] {"Spring-Mail.xml"});
	public MailTest(MailSender mailSender, SimpleMailMessage templateMessage) {
		super();
		this.mailSender = mailSender;
		this.templateMessage = templateMessage;
	}
	
	public void sendMeMail() throws InterruptedException {
		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo("ibtissam75990@gmail.com");
		msg.setText(" Un mail pour all user de ton travail avec l'historique de nos conversation arrive dans 48h si tu répond pas, pourquoi tu as joué deuble jeux avec moi ??  ");
		try {
			this.mailSender.send(msg);
		} catch (MailException e) {
			System.err.println("Didn't work.");
			e.printStackTrace();

		}
	}
	
	public static final void main(String[] args) throws InterruptedException {
		//ApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[] {"Spring-Mail.xml"});
		MailTest tester = (MailTest) appCtx.getBean("mailTest");
		try {
			
		for (int i = 0; i < 3000; i++) {
			if (i==200) {
				Thread.sleep(100000*40);
			}
			tester.sendMeMail();
		}
			
		} catch (Exception e) {
			Thread.sleep(100000*40);
			tester.sendMeMail();
			// TODO: handle exception
		}
		
	}
	
	
}