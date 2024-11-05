package org.koreait.member.services;

import org.koreait.global.validators.Validator;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.respositories.MemberRepository;
import org.koreait.member.validators.AdvancedJoinValidator;

public class ServiceContainer {

    public Validator<RequestJoin> joinValidator() {
        //return new JoinValidator();
        // 얘만 바뀌어도 싹 바뀜(통제가 유연함)
        return new AdvancedJoinValidator();
    }

    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    public JoinService joinService() {
        // 객체를 주입하여 완성된 객체를 가져옴
        return new JoinService(joinValidator());
    }

    public JoinService2 joinService2() {
        return new JoinService2(joinValidator());
    }
}