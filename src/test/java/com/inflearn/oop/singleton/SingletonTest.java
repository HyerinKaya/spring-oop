package com.inflearn.oop.singleton;

import com.inflearn.oop.AppConfig;
import com.inflearn.oop.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI컨테이터")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때마다 객체 생성
        MemberService memberService2 = appConfig.memberService();

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService2 = " + singletonService2);
        System.out.println("singletonService1 = " + singletonService1);
        //같은 주소값이 나옴-> 하나의 객체만 사용

        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
