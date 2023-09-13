package com.lucasdsf.api.vechiclerental.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MessageConstantsProperties {
	
	public static String HOST;
	public static int PORT;
	public static String USER_NAME;
	public static String PASSWORD;
	public static String PROTOCOL;
	public static boolean AUTH;
	public static boolean START_LLS;
	public static int CONNECT_TIMEOUT;
	
	public static String SENDER;

	@Value("${mail.sender}")
	public void setSender(String sender) {
		SENDER = sender;
	}
	@Value("${mail.smtp.host}")
	public void setHost(String host) {
		HOST = host;
	}
	@Value("${mail.smtp.port}")
	public void setPort(int port) {
		PORT = port;
	}
	@Value("${mail.smtp.username}")
	public void setUserName(String userName) {
		USER_NAME = userName;
	}
	@Value("${mail.smtp.password}")
	public void setPassword(String password) {
		PASSWORD = password;
	}
	@Value("${mail.transport.protocol}")
	public void setProtocol(String protocol) {
		PROTOCOL = protocol;
	}
	@Value("${mail.smtp.auth}")
	public void setAuth(boolean auth) {
		AUTH = auth;
	}
	@Value("${mail.smtp.starttls.enable}")
	public void setStartLlsEnable(boolean startLls) {
		START_LLS = startLls;
	}
	@Value("${mail.smtp.connectiontimeout}")
	public void setConnectionTimeout(int connectiontimeout) {
		CONNECT_TIMEOUT = connectiontimeout;
	}
	
	
	
}
