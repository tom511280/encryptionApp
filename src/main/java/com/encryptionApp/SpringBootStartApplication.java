package com.encryptionApp;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootStartApplication extends SpringBootServletInitializer {
	private static final Logger logger = Logger.getLogger(SpringBootStartApplication.class);

	// 此部分由main啟動時才會進行
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStartApplication.class, args);
	}

	// 此部分由外部tomcat啟動時才會進行
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		logger.info("啟動ServletInitializer.configure");
		return builder.sources(SpringBootStartApplication.class);
	}
}
