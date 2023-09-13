package com.lucasdsf.api.vechiclerental.integration.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucasdsf.api.vechiclerental.integration.sevices.IntegrationFipeService;

import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

@Configuration
public class IntegrationConfig {
	private static final Logger logger = LoggerFactory.getLogger(IntegrationConfig.class);
	
	@Value("${feign.url-basic}")
	private String urlBasic;

	@Value("${feign.client.config.default.readTimeout}")
	private int readTimeout;

	@Value("${feign.client.config.default.connectTimeout}")
	private int connectTimeout;
	
	@Bean
	public IntegrationFipeService integrationFipeService() {
		return configure(IntegrationFipeService.class);
	}
	
	private <T> T configure(Class<T> clazz) {
		logger.debug("{} : {}", "URI", urlBasic);
		return Feign.builder()
			.logger(new Slf4jLogger(clazz))
            .logLevel(feign.Logger.Level.FULL)
            .options(new Request.Options(connectTimeout * 1000, readTimeout * 1000))
			.encoder(new JacksonEncoder())
			.decoder(new JacksonDecoder())
			.target(clazz, urlBasic);
	}
}
