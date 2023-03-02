package com.inflearn.oop.member;

public class MemberServiceImpl implements MemberService{

    //오버라이드한 MemoryMemberRepository가 호출됨
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
