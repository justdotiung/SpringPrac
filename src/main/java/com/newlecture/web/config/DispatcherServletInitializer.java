package com.newlecture.web.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//getClass() 의 모든것을 말한다
		return new Class[] {
			//servlet-context.xml의 설정들을 옮기는 클래스를 만들어준다.
			ServletContextConfig.class,
			ServiceContextConfig.class,
			SecurityContextConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		return new Filter[] {
				encodingFilter
		};
	}
}
