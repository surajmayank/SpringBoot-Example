package com.example.TestRestApi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InterceptorAppConfig implements WebMvcConfigurer  {
	@Autowired
	Interceptor  interceptor;
	
	@Override
	public void addInterceptors (InterceptorRegistry interceptorRegistry) {
		
		log.info("this method will get invoked by container while deployment");
		log.info("value of interceptor is "+interceptor);
		interceptorRegistry.addInterceptor(interceptor);
	}
}
