package org.koreait.config;

import org.koreait.exam04.Calculator;
import org.koreait.exam04.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// 설정이 싹 추가됨(자동 프록시)
/**
 * 서브클래스 기반의 프록시 변환
 * 자바 표준은 인터페이스 기반의 프록시이다.
 * 스프링 쪽에는 기능을 확장해서 서브클래스 기반 프록시도 구현!
 */
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean
    public SpringCachedCalculator springCachedCalculator() {
        return new SpringCachedCalculator();
    }

    @Bean
    public SpringProxyCalculator springProxyCalculator() {
        return new SpringProxyCalculator();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }

    /*
    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }

     */
}