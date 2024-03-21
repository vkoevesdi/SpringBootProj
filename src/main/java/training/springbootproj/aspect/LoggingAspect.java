package training.springbootproj.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class LoggingAspect {

    @Before("bean(*Controller)")
    public void loggingBefore(JoinPoint joinPoint) {
        long start = System.currentTimeMillis();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.info(String.format("Class: %s, Method: %s, Started: %d", className, methodName, start));
    }

    @After("bean(*Controller)")
    public void loggingAfter(JoinPoint joinPoint) {
        long finish = System.currentTimeMillis();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.info(String.format("Class: %s, Method: %s, Finished: %d", className, methodName, finish));
    }

    @Around("bean(*Controller) || bean(*Service*) || bean(*Repository*)")
    public Object loggingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long finish = System.currentTimeMillis();

        long difference = finish - start;

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.info(String.format("Class: %s, Method: %s, Duration: %d ms", className, methodName, difference));
        return proceed;
    }
}
