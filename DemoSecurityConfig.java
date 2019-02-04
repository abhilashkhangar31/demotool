package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filters.NoScriptDetector;

@EnableWebSecurity
@Configuration
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	protected UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Request authorization settings.
		http.authorizeRequests()
				
				.antMatchers( "/", "/login" ).permitAll()
				.antMatchers("/user").hasRole("USER")
				.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated().and()
				
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/welcome", true)
				.failureUrl("/login")
				.usernameParameter("username").passwordParameter("password").and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("JSESSIONID").clearAuthentication(true)
				.invalidateHttpSession(true).and()
				
				.csrf().and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");
		
		// Session management settings.
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1)
				.expiredUrl("/login").and()
				.enableSessionUrlRewriting(false)
				.sessionFixation().migrateSession();
		
		// Configure filter before authentication process to detect whether JavaScript is enabled or not.
		http.addFilterAfter(noScriptDetector(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public NoScriptDetector noScriptDetector() {
		return new NoScriptDetector();
	}
}
