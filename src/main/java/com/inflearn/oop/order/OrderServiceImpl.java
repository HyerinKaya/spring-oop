package com.inflearn.oop.order;

import com.inflearn.oop.discount.DiscountPolicy;
import com.inflearn.oop.discount.FixDiscountPolicy;
import com.inflearn.oop.member.Member;
import com.inflearn.oop.member.MemberRepository;
import com.inflearn.oop.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
