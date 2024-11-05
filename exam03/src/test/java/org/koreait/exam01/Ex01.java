package org.koreait.exam01;

import org.junit.jupiter.api.Test;
import org.koreait.exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class Ex01 {
    @Test
    void test1() {
        // ★이 곳에서 객체 생성 -> 의존 설정 -> 초기화가 이루어짐★
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Message m1 = ctx.getBean(Message.class);
        m1.send("안녕하세요!");

        Message m2 = ctx.getBean(Message.class);
        System.out.println(m1 == m2); // true

        ctx.close(); // 소멸 전 destroy() 호출

    }

    @Test
    void test02() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Message2 m1 = ctx.getBean(Message2.class);
        Message2 m2 = ctx.getBean(Message2.class);

        System.out.println(m1 == m2);

        ctx.close();
    }
}
