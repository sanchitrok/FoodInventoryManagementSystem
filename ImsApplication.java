package com.ead.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
* This is the main entry point for Spring Boot Server.
*/
@SpringBootApplication
public class ImsApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ImsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ImsApplication.class, args);

	}

}
