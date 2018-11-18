package com.yumei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * 项目启动类。
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
@SpringBootApplication
@EnableRedisHttpSession
@MapperScan("com.yumei.*.dao")
public class Application {
	
	/**
	 * springBoot启动函数。
	 * 
	 * @param args 运行时参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
