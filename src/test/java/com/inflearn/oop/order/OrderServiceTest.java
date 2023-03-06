package com.inflearn.oop.order;

import com.inflearn.oop.AppConfig;
import com.inflearn.oop.member.Grade;
import com.inflearn.oop.member.Member;
import com.inflearn.oop.member.MemberService;
import com.inflearn.oop.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
