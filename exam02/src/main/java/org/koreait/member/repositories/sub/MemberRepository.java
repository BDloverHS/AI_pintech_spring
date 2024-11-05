package org.koreait.member.repositories.sub;

import org.springframework.stereotype.Repository;

// 다른 패키지, 같은 클래스명이라면 오류가 걸림.(Bean 이름 중복) / 빈을 이름이 결정되는데에는 클래스명만을 보기 때문

// 그렇기 때문에 Bean 이름을 재정의 할 필요가 있음.
@Repository("memRepo2")
public class MemberRepository { // 빈 이름 : memberRepository

}
