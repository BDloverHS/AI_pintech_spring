package org.koreait.exam01.config;

import org.koreait.exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너가 관리할 객체의 설정 클래스임을 알려주는 어노테이션
@Configuration
public class AppCtx {

    // 스프링 컨테이너가 관리할 객체임을 알려주는 어노테이션
    @Bean
    public Greeter greeter() {
        return new Greeter();
    }
}
