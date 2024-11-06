// Spring Proxy

package org.koreait.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Order(2)
// @Aspect = Proxy Class 임을 명시하는 Annotation
@Aspect
public class SpringProxyCalculator {

    // 반환값 *(전체)
    // 적용대상 ..*(해당 패키지 포함한 하위 패키지의 모든 클래스)
    // 메서드 (..) 모든 메서드..?
    @Pointcut("execution(* org.koreait.exam04..*(..))")
    public void publicTarget() {

    }

    /*
    @Before("publicTarget()")
    public void beforeProcess(JoinPoint joinPoint) {
        System.out.println("@Before 중!!");
    }

    @After("publicTarget()")
    public void afterProcess(JoinPoint joinPoint) throws Throwable {
        System.out.println("@After 중!!");
    }
    */


    // @Around("publicTarget()")
    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        long stime = System.nanoTime();

        try {
            // 핵심 기능을 대신 호출해 수행
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long etime = System.nanoTime();
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}

/*
package org.koreait.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SpringProxyCalculator {

    // * : 모든 반환값 타입을 의미
    // org.koreait.exam04.. : org.koreait.exam04의 모든 하위 패키지를 의미
    // *(..) : 패키지 내 모든 메서드를 의미
    @Pointcut("execution(* org.koreait.exam04..*(..))")
    public void publicTarget() {

    }

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {

        long stime = System.nanoTime();

        try {
            Object result = joinPoint.proceed(); // 핵심 기능을 대신 수행

            System.out.println("호출!!!");

            return null;
        } finally {
            long etime = System.nanoTime();
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }


    }
}
*/
