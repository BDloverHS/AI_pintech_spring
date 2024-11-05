package org.koreait.member.services;

import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.repositories.MemberRepository;
import org.koreait.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 회원 가입 기능
 */
public class JoinService {

    // 의존성 자동 접근
    @Autowired
    public JoinValidator validator;

    @Autowired
    @Qualifier("mRepo2")
    public MemberRepository repository;

    /*public JoinService(JoinValidator validator, MemberRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }*/

    /**
     * 가입 처리
     * 데이터 클래스 쪽은 의존 주입을 하면 안 된다.
     */
    public void process(RequestJoin form) {
        validator.validate(form); // 유효성 검사
        repository.register(form); // 영구 저장 처리
    }
}