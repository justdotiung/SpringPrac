package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityContextConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http 설정이 일로온다
		http
			.authorizeRequests()
				.antMatchers("/admin/**")
					.hasRole("ADMIN")
				.antMatchers("/studnet/**")
					//xml이 아닌곳에선 role_ 생략가능
					.hasAnyRole("ADMIN","DMIN")
				.and()
			.formLogin()
				.loginPage("/member/login")
				.defaultSuccessUrl("/index")
				.and()//다음설정 이어간다는 함수
			.logout()
				.logoutUrl("/member/logout")
				.logoutSuccessUrl("/index")
				;
	
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT ID, PWD PASSWORD, 1 ENABLED FROM MEMBER WHERE ID=?")
				.authoritiesByUsernameQuery("SELECT ID ,'ROLE_ADMIN' AUTHORITY FROM MEMBER WHERE ID =?")
				.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	

}
