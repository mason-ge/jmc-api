package com.jmc.api.config;

import com.jmc.api.common.CorsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description: mvc配置
 * @Author: mason_ge
 * @Date: 16:12 2018/12/18
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
	// 配置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CorsInterceptor()).addPathPatterns("/**");
	}
}
