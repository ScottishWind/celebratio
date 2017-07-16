package com.xcommerce.online.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class TestConfigurationService {
	
	private final Logger logger = LoggerFactory.getLogger(TestConfigurationService.class);

	@Value("${name}")
	private String name;

	public String getName() {
		logger.info("ame from the config server : "+name);
		return name;
	}
}
