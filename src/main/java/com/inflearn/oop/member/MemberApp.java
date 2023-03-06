package com.inflearn.oop.member;

import com.inflearn.oop.AppConfig;
import com.inflearn.oop.member.Grade;
import com.inflearn.oop.member.Member;
import com.inflearn.oop.member.MemberService;
import com.inflearn.oop.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member=" + member.getName());
        System.out.println("find member=" + findMember.getName());

    }
}
