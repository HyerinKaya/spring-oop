package com.inflearn.oop.order;

import com.inflearn.oop.AppConfig;
import com.inflearn.oop.member.Grade;
import com.inflearn.oop.member.Member;
import com.inflearn.oop.member.MemberService;
import com.inflearn.oop.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);

        System.out.println("order = "+order);
    }
}
