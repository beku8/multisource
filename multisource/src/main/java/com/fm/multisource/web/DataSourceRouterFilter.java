package com.fm.multisource.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fm.multisource.datasource.CustomerContextHolder;

/**
 * Servlet Filter implementation class DataSourceRouterFilter
 */
public class DataSourceRouterFilter implements Filter {
	
	private	Logger logger = LoggerFactory.getLogger(getClass());

	public void destroy() {
		logger.debug("destroying DataSourceRouterFilter filter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("entered filter");
		
		if(SecurityContextHolder.getContext().getAuthentication() != null){
			String name = SecurityContextHolder.getContext().getAuthentication().getName();
			logger.debug("current user: {}", name);
			
			if(name.equals("admin")){
				CustomerContextHolder.setCustomerType(2);
				logger.debug("setting source to {}", 2);
			}
			else if(name.equals("koala")){
				CustomerContextHolder.setCustomerType(3);
				logger.debug("setting source to {}", 3);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.debug("initializing DataSourceRouterFilter filter");
	}

}
