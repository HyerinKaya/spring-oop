package com.inflearn.oop;

import com.inflearn.oop.discount.DiscountPolicy;
import com.inflearn.oop.discount.FixDiscountPolicy;
import com.inflearn.oop.member.MemberService;
import com.inflearn.oop.member.MemberServiceImpl;
import com.inflearn.oop.member.MemoryMemberRepository;
import com.inflearn.oop.order.OrderService;
import com.inflearn.oop.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
