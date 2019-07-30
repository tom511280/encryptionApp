package com.encryptionApp.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(*  com.EncryptionApp..*.*(..))")
    public void webLog(){}
	
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 紀錄請求內容
    	String location = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    	String args = Arrays.toString(joinPoint.getArgs());

    	String doBeforeLog = "[doBefore aop] [location: %s] [para:%s]";
		String doBeforeLogResult = String.format(doBeforeLog, location, args);
		logger.info(doBeforeLogResult);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        //返回內容
    	String location = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    	
    	String doAfterReturningLog = "[doAfterReturning aop] [location: %s] [return:%s]";
		String doAfterReturningResult = String.format(doAfterReturningLog, location, ret);    
        logger.info(doAfterReturningResult);
    }

}
