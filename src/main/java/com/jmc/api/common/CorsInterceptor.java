
package com.jmc.api.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description:自定义拦截器
 * @Author: mason_ge
 * @Date: 14:28 2018/11/21
 */
public class CorsInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
		String origin = httpServletRequest.getHeader("Origin");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				"Origin,Content-Type,Accept,token,X-Requested-With");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		return true;
	}
	// 其他postHandle,afterCompletion空继承
}