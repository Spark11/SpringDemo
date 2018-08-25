package com.andrey.spring.demo.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
	
	@Pointcut("execution(* com.andrey.spring.demo.persistence.dao.*.*(..))")
	private void pointcutDaoLogging() {
	}

	@Before("pointcutDaoLogging()")
	public void beforeMethodOne() {
		System.out.println("[Logger]: DAO method begin.");
	}

	@After("pointcutDaoLogging()")
	public void afterMethodOne() {
		System.out.println("[Logger]: DAO method end.");
	}
	
}
