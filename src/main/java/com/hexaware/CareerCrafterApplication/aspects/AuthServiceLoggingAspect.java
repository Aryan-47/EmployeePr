package com.hexaware.CareerCrafterApplication.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthServiceLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceLoggingAspect.class);

    // Log before method execution
    @Before("execution(* com.hexaware.CareerCrafterApplication.service.AuthServiceImpl.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Method {} is about to be executed", joinPoint.getSignature().getName());
    }

    // Log after method execution
    @After("execution(* com.hexaware.CareerCrafterApplication.service.AuthServiceImpl.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("Method {} has been executed", joinPoint.getSignature().getName());
    }

    // Log after method returns a value
    @AfterReturning(value = "execution(* com.hexaware.CareerCrafterApplication.service.AuthServiceImpl.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} executed successfully with result: {}", joinPoint.getSignature().getName(), result);
    }

    // Log when method throws an exception
    @AfterThrowing(value = "execution(* com.hexaware.CareerCrafterApplication.service.AuthServiceImpl.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Method {} threw exception: {}", joinPoint.getSignature().getName(), exception.getMessage());
    }
}
