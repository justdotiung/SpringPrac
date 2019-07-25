package com.newlecture.web.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
//@Configuration
//설정파일이라 명시
@ComponentScan(basePackages="com.newlecture")
@EnableWebMvc
public class ServletContextConfig implements WebMvcConfigurer{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter converter = new StringHttpMessageConverter();
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converter.setWriteAcceptCharset(false);
		
		converters.add(converter);
		
		WebMvcConfigurer.super.configureMessageConverters(converters);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry/*예외파일 설정*/) {
		registry
			.addResourceHandler("/resource/**")
			.addResourceLocations("/resource/");
	}
	
	//객체 라는것으로 명시
	@Bean
	//함수명이 bean의 아이디 값으로 들어간다.
	public TilesConfigurer tilesConfigurer() {
		
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");
		
		return configurer;
	}
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		
		return resolver;
	}
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setPrefix("/WEB-INF/view/");
		
		return internalResourceViewResolver;
	}
	
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver =new CommonsMultipartResolver();
		//1024*1024*100 100m 
		commonsMultipartResolver.setMaxUploadSize(314572800L);
		return commonsMultipartResolver;
	}
}
