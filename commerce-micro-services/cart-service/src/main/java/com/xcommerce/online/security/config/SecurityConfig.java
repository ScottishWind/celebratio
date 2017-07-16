package com.xcommerce.online.security.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xcommerce.online.security.filter.AuthenticationFilter;

@Configuration

public class SecurityConfig  {

	@Bean
    public FilterRegistrationBean dawsonApiFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());
// In case you want the filter to apply to specific URL patterns only
        registration.addUrlPatterns("/user/secure/*");
        return registration;
    }

}
