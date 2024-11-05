package org.koreait.global.configs;

import org.koreait.member.repositories.MemberRepository;
import org.koreait.member.services.InfoService;
import org.koreait.member.services.JoinService;
import org.koreait.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.format.DateTimeFormatter;

@Configuration
// 의존성 자동 주입
public class AppCtx3 {


    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator();
    }

    /*
    @Bean
    @Qualifier("mRepo")
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Bean
    @Qualifier("mRepo2")
    public MemberRepository memberRepository2() {
        return new MemberRepository();
    }
    */
    /*
    @Bean
    public JoinService joinService() {
        return new JoinService();
    }

    @Bean
    public InfoService infoService() {
        return new InfoService();
    }

    @Bean
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    }
    */
}
