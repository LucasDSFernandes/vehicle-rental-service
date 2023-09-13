package com.lucasdsf.api.vechiclerental.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(MessageConstantsProperties.HOST);
		mailSender.setPort(MessageConstantsProperties.PORT);
		mailSender.setUsername(MessageConstantsProperties.USER_NAME);
		mailSender.setPassword(MessageConstantsProperties.PASSWORD);
		
		Properties props = new Properties();
		props.put("mail.transport.protocol", MessageConstantsProperties.PROTOCOL);
		props.put("mail.smtp.auth", MessageConstantsProperties.AUTH);
		props.put("mail.smtp.starttls.enable", MessageConstantsProperties.START_LLS);
		props.put("mail.smtp.connectiontimeout", MessageConstantsProperties.CONNECT_TIMEOUT*1000);
		
		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}
}
