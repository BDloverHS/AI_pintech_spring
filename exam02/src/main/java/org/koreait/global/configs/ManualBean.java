package org.koreait.global.configs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이 두 가지 어노테이션은 고정

// Target : 클래스명 위에
@Target(ElementType.TYPE)

// 실행 범위
@Retention(RetentionPolicy.RUNTIME)
public @interface ManualBean {
}
