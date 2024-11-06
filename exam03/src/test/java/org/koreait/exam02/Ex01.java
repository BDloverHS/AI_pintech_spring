package org.koreait.exam02;

import org.junit.jupiter.api.Test;

public class Ex01 {
    @Test
    void test01() {
        // 매우 짧은 시간
        long stime = System.nanoTime(); // 공통 기능

        ImplCalculator cal1 = new ImplCalculator(); // 성능이 좋음
        long result1 = cal1.factorial(10L); // 핵심 기능
        System.out.printf("cal1 : %d%n", result1);

        // 매우 긴 시간
        long etime = System.nanoTime(); // 공통 기능

        System.out.printf("cal1 걸린 시간 : %d%n", etime - stime);


        stime = System.nanoTime(); //  공통 기능


        RecCalculator cal2 = new RecCalculator(); // 성능이 좋지 않음
        long result2 = cal2.factorial(10L); // 핵심 기능
        System.out.printf("cal2 : %d%n", result2);


        etime = System.nanoTime();
        System.out.printf("cal2 걸린 시간 : %d%n", etime - stime);
    }

    @Test
    void test02() {
        Calculator cal1 = new ProxyCalculator(new ImplCalculator());
        long result1 = cal1.factorial(10L);
        System.out.printf("cal1=%d%n", result1);

        Calculator cal2 = new ProxyCalculator(new RecCalculator());
        long result2 = cal2.factorial(10L);
        System.out.printf("cal2=%d%n", result2);
    }

    @Test
    void test03() {
        Calculator cal = new CachedCalculator(new ProxyCalculator(new RecCalculator()));

        long r1 = cal.factorial(49L);
        System.out.printf("r1=%d%n", r1);
        long r2 = cal.factorial(10L);
        System.out.printf("r2=%d%n", r2);
        long r3 = cal.factorial(10L);
        System.out.printf("r3=%d%n", r3);
    }
}