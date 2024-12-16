package com.hexaware.CareerCrafterApplication.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationServiceAspect {

    Logger log = LogManager.getLogger(ApplicationServiceAspect.class);

    @Pointcut("execution(* com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl.applyToJob(..))")
    public void applyToJobPointcut() {
    }

    @Before("applyToJobPointcut()")
    public void logBeforeApplyToJob(JoinPoint joinPoint) {
        log.info("Method: {} called with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "execution(* com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl.applyToJob(..))", throwing = "error")
    public void logAfterThrowingApplyToJob(JoinPoint joinPoint, Throwable error) {
        log.error("Exception in method: {} with message: {}", joinPoint.getSignature().getName(), error.getMessage());
    }

    @Pointcut("execution(* com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl.getApplicationsByEmployer(..))")
    public void getApplicationsByEmployerPointcut() {
    }

    @Before("getApplicationsByEmployerPointcut()")
    public void logBeforeGetApplicationsByEmployer(JoinPoint joinPoint) {
        log.info("Method: {} called with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "execution(* com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl.getApplicationsByEmployer(..))", throwing = "error")
    public void logAfterThrowingGetApplicationsByEmployer(JoinPoint joinPoint, Throwable error) {
        log.error("Exception in method: {} with message: {}", joinPoint.getSignature().getName(), error.getMessage());
    }

    @Pointcut("execution(* com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl.updateApplicationStatus(..))")
    public void updateApplicationStatusPointcut() {
    }

    @Before("updateApplicationStatusPointcut()")
    public void logBeforeUpdateApplicationStatus(JoinPoint joinPoint) {
        log.info("Method: {} called with arguments: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "execution(* com.hexaware.CareerCrafterApplication.service.ApplicationServiceImpl.updateApplicationStatus(..))", throwing = "error")
    public void logAfterThrowingUpdateApplicationStatus(JoinPoint joinPoint, Throwable error) {
        log.error("Exception in method: {} with message: {}", joinPoint.getSignature().getName(), error.getMessage());
    }
}