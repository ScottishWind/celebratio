package com.xcommerce.online.config;

/**
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.web.servlet.config.annotation.CorsRegistry; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc; import
 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 * 
 * @Configuration
 * @EnableWebMvc 
 * public class SecurityConfig extends WebMvcConfigurerAdapter {
 * 
 * @Override 
 * TODO -- Facing problems with swagger 
 * public void addCorsMappings(CorsRegistry registry) {
 *           registry.addMapping("/**").allowedOrigins("*"); 
 *           }
 * 
 * }
 *           
 * @Configuration
 * public class SecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * @Override 
 * protected void configure(HttpSecurity httpSecurity) throws Exception {
 *           httpSecurity.authorizeRequests().antMatchers("/").permitAll(); 
 *           } 
 *}
 **/
