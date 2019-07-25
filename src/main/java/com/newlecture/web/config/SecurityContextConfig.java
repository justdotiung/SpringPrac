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
		//http ������ �Ϸο´�
		http
			.authorizeRequests()
				.antMatchers("/admin/**")
					.hasRole("ADMIN")
				.antMatchers("/studnet/**")
					//xml�� �ƴѰ����� role_ ��������
					.hasAnyRole("ADMIN","DMIN")
				.and()
			.formLogin()
				.loginPage("/member/login")
				.defaultSuccessUrl("/index")
				.and()//�������� �̾�ٴ� �Լ�
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
