package com.dsv.SpringBootRest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //syntax is return type class-name.method-name(args)
    @Before("execution(* com.dsv.SpringBootRest.service.JobService.getJob(..)) || execution(* com.dsv.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp){ //hold on the log before information
        LOGGER.info("Log method called"+jp.getSignature().getName());
    }



}
