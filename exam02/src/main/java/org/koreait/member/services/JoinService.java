package org.koreait.member.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.repositories.MemberRepository;
import org.koreait.member.validators.JoinValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 회원 가입 기능
 */
@Service

// 초기화가 반드시 필요한 인스턴스 변수를 생성자 매개변수에 추가
@RequiredArgsConstructor
public class JoinService { // 빈 이름 joinService

    // public 뒤에 final을 추가하면 생성자가 자동으로 만들어짐.
    public final JoinValidator validator;

    // final은 상수처리로, 변하지 않기 때문에 Nonnull을 사용하여 Null이 아니도록 설정해도 생성자 자동 생성 가능
    @NonNull
    public MemberRepository repository;

    /*
    public JoinService(JoinValidator validator, MemberRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }
    */

    /*
    // 의존성 자동 접근
    @Autowired
    public JoinValidator validator;

    @Autowired
    @Qualifier("mRepo2")
    public MemberRepository repository;
    */


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