package com.rbc.stock.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Around("execution(* com.rbc.stock.service.impl..*(..)) || execution(* com.rbc.stock.controller..*(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Entering method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		Object obj = joinPoint.proceed();
		
		log.info("Exiting method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		return obj;
	}
	
	@AfterThrowing(pointcut = "execution(*  com.rbc.stock.service.impl..*(..)) ||  execution(* com.rbc.stock.controller..*(..))",
					throwing = "ex")
	public void logError(JoinPoint jp , Exception ex) throws Exception {
		log.info("Exception occured in : "+ jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName()
				+ " Exception : [" + ex + "]");
		throw ex;
	}
}

