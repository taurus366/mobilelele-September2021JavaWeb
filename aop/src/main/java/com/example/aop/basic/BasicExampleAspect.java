package com.example.aop.basic;

import com.example.aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;

@Aspect
//@ConditionalOnProperty(name = "examples.basic.enabled", havingValue = "true")
@Component
public class BasicExampleAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicExampleAspect.class);

    @Pointcut("execution(* com.example.aop.Student.*(..))")
    public void track() {
    }

    @Pointcut("execution(* com.example.aop.Student.echo(..))")
    public void trackEcho() {

    }

    @Pointcut("execution(* com.example.aop.Student.test(..))")
    public void trackTest() {

    }

        @Before("trackTest()")
    public void beforeAnyMethod(JoinPoint joinPoint) {
        LOGGER.info("Before calling: {}",joinPoint.getSignature());
        System.out.println(joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.example.aop.Student.test(..)))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("test");

    }




//    @Before("track()")
//    public void beforeAnyMethod(JoinPoint joinPoint) {
//        LOGGER.info("Before calling: {}",joinPoint.getSignature());
//        System.out.println(joinPoint.getSignature());
//    }

//    @Before("trackEcho()")
//    public void beforeEcho() {
//        LOGGER.info("Advice execution before calling echo.");
//    }
//
//    @AfterThrowing(pointcut = "track()", throwing = "error")
//    public void trackExceptions(Throwable error) {
//        LOGGER.info("I have detected an exception: ",error);
//    }
}
