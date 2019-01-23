package com.mani.stock.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	 @Override
	    protected void configure(final HttpSecurity http) throws Exception {
	        http
	          .csrf().disable()
	          .authorizeRequests()
	          .antMatchers("/admin/**").hasRole("ADMIN")
	          .antMatchers("/anonymous*").anonymous()
//	          .antMatchers("/*").permitAll()
	          .antMatchers("/login*").permitAll()
	          .anyRequest().authenticated()
	          .and()
	          .formLogin()
	          .loginPage("/login")
	          .loginProcessingUrl("/perform_login")
	          .defaultSuccessUrl("/stock", true)
	          //.failureUrl("/login.html?error=true")
	          //.failureHandler(authenticationFailureHandler())
	          .and()
	          .logout()
	          .logoutUrl("/perform_logout")
	          .deleteCookies("JSESSIONID");
	         // .logoutSuccessHandler(logoutSuccessHandler());
	    }
}
