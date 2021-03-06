package com.hendisantika.excelpoi.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by liuyan on 2019/1/16.
 */
@Aspect
@Slf4j
public class LogAdapter {

    public final String sss = "execution(public * com.hendisantika.excelpoi..*(..))";
    public String aaa = "execution(public * com.hendisantika.excelpoi..*(..))";

    @Pointcut(sss)
    public void pubulicMethodPointcut() {
    }

//    @Around("pubulicMethodPointcut()")
//    public void around(ProceedingJoinPoint joinPoint) {
//
//        log.info("Class Name: {} , methodName");
//    }

    @AfterReturning(value = "pubulicMethodPointcut()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getSignature().getDeclaringType().getName();
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        log.info("Class Name: {} , methodName: {} , arg : {} , result: {}", className, methodName, args, result);
    }

    @AfterThrowing("pubulicMethodPointcut()")
    public void afterThrowing(JoinPoint joinPoint) {
        joinPoint.getSignature();
        System.out.println("异常出现之后...afterThrowing");
    }


}
