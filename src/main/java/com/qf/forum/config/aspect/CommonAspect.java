package com.qf.forum.config.aspect;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 20:11
 */


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class CommonAspect {

    @Pointcut("@annotation(com.qf.forum.config.aspect.annotation.LoginCheck)")
    public void pointCount() {}

    @Before("pointCount()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知");
        System.out.println("被增强的方法签名-----------"+joinPoint.getSignature());
        System.out.println("被增强的方法名-----------"+joinPoint.getSignature().getName());
        System.out.println("被增强的方法参数数组-----------"+ Arrays.asList(joinPoint.getArgs()));
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getStaticPart());
//        throw new RuntimeException();
    }

    /**
     * 后置通知
     */
//    @After(value = "pointCount()")
    public void After(){
        System.out.println("---------后置通知-----------");
    }

    /**
     * 后置返回通知
     * @param joinPoint
     * @param re
     */
//    @AfterReturning(value = "pointCount()",returning = "re", argNames = "joinPoint,re")
//    public void AfterReturning(JoinPoint joinPoint, Object re){
//        System.out.println(joinPoint.getSignature().toShortString());
//
//        System.out.println("--------后置返回通知 返回--------"+re);
//    }

    /**
     * 后置异常通知
     * @param exception
     */
//    @AfterThrowing(value = "pointCount()",throwing = "exception")
    public void AfterThrowing(Exception exception){
        System.out.println("-----------"+"异常通知");
    }

    /**
     * 环绕通知
     * @param pJoinPoint
     */
//    @Around("execution(* com.bug.service.*.*(..))")
    @Around(value = "pointCount()")
    public Object around(ProceedingJoinPoint pJoinPoint){
        System.out.println("----------环绕通知调用方法-----"+pJoinPoint.getSignature().getName());
        Object obj=null;
        Object[] args = pJoinPoint.getArgs();
        try {
            for(Object o : args) {
                if(o instanceof HttpServletRequest) {
                    HttpServletRequest request = (HttpServletRequest) o;
                    System.out.println(request.getSession().getId());
                    assert request.getSession().getAttribute("user") != null;
                    obj=pJoinPoint.proceed(args);
                    System.out.println("执行原方法");
                }
            }

        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            System.out.println("---环绕通知结束---");
        }
        return obj;
    }



}
