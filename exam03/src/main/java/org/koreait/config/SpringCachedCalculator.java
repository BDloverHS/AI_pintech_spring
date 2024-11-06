package org.koreait.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

// 프록시를 사용하겠다 / AOP를 적용하겠다
@Order(1)
@Aspect
public class SpringCachedCalculator {

    private Map<Long, Object> cache = new HashMap<>();

    // org.koreait.exam04 패키지의 모든 하위 패키지 내의 메서드 정보가 담김 ..*(..))
    // @Pointcut("execution(* org.koreait.exam04..*(..))")
    // public void publicTarget() {}

    @Around("CommonPointcut.publicTarget()")
    // @Around("execution(* org.koreait.exam04..*(..))")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        long num = (long)args[0];
        if (cache.containsKey(num)) {
            // cache에 값이 있다면 그 값을 가져옴
            System.out.println("캐시에서 가져옴");
            // return 시 함수 종료
            return cache.get(num);
        }

        // 캐시가 없을 때
        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.println("캐시에 값 저장...");

        return result;
    }
}
