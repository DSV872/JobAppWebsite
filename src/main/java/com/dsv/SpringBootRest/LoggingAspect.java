package com.dsv.SpringBootRest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        LOGGER.info("Log method called "+jp.getSignature().getName());
    }

    @After("execution(* com.dsv.SpringBootRest.service.JobService.getJob(..)) || execution(* com.dsv.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodEx(JoinPoint jp){ //hold on the log before information
        LOGGER.info("Log method executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.dsv.SpringBootRest.service.JobService.getJob(..)) || execution(* com.dsv.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Log method has some issues "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.dsv.SrpingBootRest.service.JobService.getJob(..)) || execution(* com.dsv.SpringBootRest.service.JobService.updateJob(..))")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Log method executed successfully "+jp.getSignature().getName());
    }

}
