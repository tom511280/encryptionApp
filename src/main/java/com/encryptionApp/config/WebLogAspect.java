package com.encryptionApp.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class WebLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

//    @Pointcut("execution(*  com.encryptionApp.*.*(..))")
	@Pointcut("execution(* com.encryptionApp..*.*.*(..))")
    public void webLog(){}
	
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	ObjectMapper obj = new ObjectMapper(); 
        // 紀錄請求內容
    	String location = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    	String args =  "";
    	try{
    		args =  obj.writeValueAsString(joinPoint.getArgs());
    	}catch(Exception e){
    		logger.error("解析args失敗");
    	}
    	
    	String doBeforeLog = "[doBefore aop] [location: %s] [para:%s]";
		String doBeforeLogResult = String.format(doBeforeLog, location, args);
		logger.info(doBeforeLogResult);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
    	ObjectMapper obj = new ObjectMapper(); 
    	// 紀錄請求內容
    	String returnString = ret.toString();
    	try{
    		returnString =  obj.writeValueAsString(ret);
    	}catch(Exception e){
    		logger.error("解析ret失敗");
    	}
    	
    	String location = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    	String doAfterReturningLog = "[doAfterReturning aop] [location: %s] [return:%s]";
		String doAfterReturningResult = String.format(doAfterReturningLog, location, returnString);    
        logger.info(doAfterReturningResult);
    }

}
