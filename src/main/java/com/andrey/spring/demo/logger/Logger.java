package com.andrey.spring.demo.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

	@Pointcut("execution(* com.andrey.spring.demo.persistence.dao.*.*(..))")
	private void daoMethod() {
	}

	@Before(value = "daoMethod()")
	public void beforeDaoMethod(JoinPoint joinPoint) {
		System.out.println("[Logger]: DAO method '" + joinPoint.getSignature().getName() + "' called.");
	}

	@AfterReturning(value = "daoMethod()", returning = "retVal")
	public void afterReturningFromDaoMethod(JoinPoint joinPoint, Object retVal) {
		System.out.println("[Logger]: DAO method '" + joinPoint.getSignature().getName() + "' returned "
				+ (retVal != null ? "successfully." : "with error."));
	}

}
