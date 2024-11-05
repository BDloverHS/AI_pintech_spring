package org.koreait.global.configs;

import org.koreait.member.repositories.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "org.koreait.member"
        // ManualBean 배제
        // , excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = ManualBean.class)
        // classes를 여러 개 선언할 때는 {} 안에 작성
        // MemberRepository를 사용하는 모든 곳 배제
        // , excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberRepository.class)
        //
        , excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "org.koreait..*Reoisitory")


)
public class AppCtx4 {

    // 아래 코드를 주석 처리 시
    /*
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppCtx 호출");
        return new MemberRepository();
    }
    */
}
