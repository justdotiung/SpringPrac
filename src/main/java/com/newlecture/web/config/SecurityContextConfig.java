package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.newlecture.web.service.UserDetailsServiceImpl;

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
					.hasAnyRole("ADMIN","STUDENT")
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
	//쿼리문의 집중화도 된다. dao를 위임하게 되기떄문에 아래에 메소드에서 쿼리가 사라진것을 볼수있다.
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetailsService service = new UserDetailsServiceImpl();
		
		return  service;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService())
			.passwordEncoder(new BCryptPasswordEncoder());
		
		/*
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT ID, PWD PASSWORD, 1 ENABLED FROM MEMBER WHERE ID=?")
				.authoritiesByUsernameQuery("SELECT ID ,'ROLE_ADMIN' AUTHORITY FROM MEMBER WHERE ID =?")
				.passwordEncoder(new BCryptPasswordEncoder());
		
	*/
	}
	

}
