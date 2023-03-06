package com.inflearn.oop.order;

import com.inflearn.oop.discount.DiscountPolicy;
import com.inflearn.oop.member.Member;
import com.inflearn.oop.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //->DIP, OCP 위반, 다음과 같이 수정해서 DiscountPolicy 추상클래스에 의존하도록
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
