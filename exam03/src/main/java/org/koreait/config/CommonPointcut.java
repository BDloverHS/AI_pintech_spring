package org.koreait.config;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
    @Pointcut("execution(* org.koreait.exam04..*(..))")
    public void publicTarget() {

    }
}
