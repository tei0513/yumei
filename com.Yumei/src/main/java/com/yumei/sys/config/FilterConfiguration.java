package com.yumei.sys.config;


import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yumei.common.utils.consts.NumberConsts;
import com.yumei.sys.filter.AccessFilter;
import com.yumei.sys.filter.LoginFilter;
import com.yumei.sys.filter.TokenFilter;

/**
 * 过滤器配置。
 * 
 * @author Tei
 * @Date 2018年11月19日
 */
@Configuration
public class FilterConfiguration {
	
	@Autowired
	private LoginFilter loginFilter;
	
	@Autowired
	private AccessFilter accessFilter;
	
	@Autowired
	private TokenFilter tokenFilter;
	/**
	 * 注册loginFilter
	 * 
	 * @return 过滤器注册器
	 */
    @Bean
    public FilterRegistrationBean<Filter> loginFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        // 注入过滤器
        registration.setFilter(loginFilter);
        // 过滤规则
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("loginFilter");
        // 过滤器顺序
        registration.setOrder(NumberConsts.NUM_0);
        return registration;
    }
    
	/**
	 * 注册tokenFilter
	 * 
	 * @return 过滤器注册器
	 */
    @Bean
    public FilterRegistrationBean<Filter> tokenFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        // 注入过滤器
        registration.setFilter(tokenFilter);
        // 过滤规则
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("tokenFilter");
        // 过滤器顺序
        registration.setOrder(NumberConsts.NUM_4);
        return registration;
    }
    
	/**
	 * 注册accessFilter
	 * 
	 * @return 过滤器注册器
	 */
    @Bean
    public FilterRegistrationBean<Filter> registeFilterRegistration() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        // 注入过滤器
        registration.setFilter(accessFilter);
        // 过滤规则
        registration.addUrlPatterns("/*");
        // 过滤器名称
        registration.setName("accessFilter");
        // 过滤器顺序
        registration.setOrder(NumberConsts.NUM_5);
        return registration;
    }
    
}
