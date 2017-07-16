package com.commerce.online.commercediscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class })
public class CommerceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceDiscoveryServerApplication.class, args);
	}
}
