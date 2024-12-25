package com.bhabani.flexiventures.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/flexiventures/list")
				.hasAnyRole("PUBLISHER", "REVIEWER", "APPROVER").antMatchers(HttpMethod.POST, "/flexiventures/txn")
				.hasAnyRole("PUBLISHER").antMatchers(HttpMethod.PATCH, "/flexiventures/txn")
				.hasAnyRole("REVIEWER", "APPROVER").anyRequest().authenticated().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("User X").password("john").roles("PUBLISHER");
		auth.inMemoryAuthentication().withUser("User R").password("smith").roles("REVIEWER");
		auth.inMemoryAuthentication().withUser("User A").password("rair").roles("APPROVER");
		auth.inMemoryAuthentication().withUser("sara").password("mno").roles("NORMAL");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
