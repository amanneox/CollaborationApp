package com.collaborate.app.collaborateApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages={"com.collaborate.app.collaborateApp.repository", "com.collaborate.app.collaborateApp.controller","com.collaborate.app.collaborateApp.service","com.collaborate.app.collaborateApp.config"}
)
@EnableJpaAuditing
public class CollaborateAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaborateAppApplication.class, args);
	}

}
