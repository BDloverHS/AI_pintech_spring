package org.koreait.exam01.main;

import org.junit.jupiter.api.Test;
import org.koreait.exam01.Greeter;
import org.koreait.exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    @Test
    void Test1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        /**
         * AnnotationConfig : 설정 방식
         * ApplicationContext : 스프링 컨테이너
         */

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("우현수");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);

        System.out.println(g1 == g2); // true → 싱글톤 패턴이기 때문임
        
        ctx.close();
    }
}