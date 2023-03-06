package com.inflearn.oop;

import com.inflearn.oop.discount.FixDiscountPolicy;
import com.inflearn.oop.member.MemberService;
import com.inflearn.oop.member.MemberServiceImpl;
import com.inflearn.oop.member.MemoryMemberRepository;
import com.inflearn.oop.order.OrderService;
import com.inflearn.oop.order.OrderServiceImpl;

public class AppConfig {

    //생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    }
}
