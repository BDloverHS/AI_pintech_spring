package org.koreait.member.services;

import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.RequestJoin;

/**
 * 회원가입 기능
 */
public class JoinService {
    // 구성
    private Validator<RequestJoin> validator;

    /**
     * 의존 관계
     * JoinService 객체를 생성하는데 validator
     * @param validator
     * - JoinService 객체 생성을 위해서는 joinValidator가 필수!
     */
    public JoinService(Validator<RequestJoin> validator) {
        this.validator = validator;
    }

    /**
     * 연관 관계
     * JoinService 객체를 생성할 때 필수는 아니다. 연관성이 있다.
     * @param validator
     */

    /*
    public void setValidator(Validator<RequestJoin> validator) {
        this.validator = Validator;
    }
     */

    /**
     * 가입 처리
     *
     * RequestJoin - DTO(Data Transfer Object) : 사용자가 입력한 값을 전달
     */
    public void process(RequestJoin form) {
        validator.check(form);
    }
}
