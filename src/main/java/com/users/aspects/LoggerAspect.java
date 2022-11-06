package com.users.aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class LoggerAspect {

    @Around("@annotation(com.users.aspects.Logger)")
    public Object loggerController(ProceedingJoinPoint point) throws Throwable {
        final Logger LOGGER = LoggerFactory.getLogger(point.getTarget().getClass());
        List<String> splitName = Arrays.asList(point.getTarget().getClass().getName().split("\\."));
        final String className = splitName.get(splitName.size() - 1);
        final String methodName = point.getSignature().getName();
        Object[] methodArgs = point.getArgs();
        LOGGER.debug("Before to {}.{}, Request: {}", className, methodName, methodArgs);
        var response = point.proceed();
        LOGGER.debug("After to {}.{}, Response: {}", className, methodName, response.toString());
        return response;
    }

}