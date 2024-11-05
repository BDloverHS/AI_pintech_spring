package org.koreait.member.services;

import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.respositories.MemberRepository;

/**
 * 회원가입 기능
 */
public class JoinService {
    // final을 넣을 시 생성자와 매개변수가 필수가 됨.
    private final Validator<RequestJoin> validator;
    // 초기화가 필요로 하는 의존 관계
    private final MemberRepository repository;

    /**
     * 의존 관계
     *
     * @param validator - JoinService 객체 생성을 위해서는 joinValidator가 필수!
     */
    public JoinService(Validator<RequestJoin> validator, MemberRepository repository) {
        this.validator = validator;
        this.repository = repository;
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
        // form, JoinService에 서로 영향을 주고 받는 관계 - 변화에 영향을 받음
        // 통제가 필요하므로 메서드 안에 감출 필요가 있음 -> 캡슐화 / 변화에 닫힌 구조
        validator.check(form);
    }
}
