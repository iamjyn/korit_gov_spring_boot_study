package com.korit.korit_gov_spring_boot_study.repository;

import com.korit.korit_gov_spring_boot_study.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static MemberRepository instance;
    private List<Member> memberList;

    private MemberRepository() {
        memberList = new ArrayList<>();
    }

    public static MemberRepository getInstance() {
        if (instance == null) {
            instance = new MemberRepository();
        }
        return instance;
    }

    public Member findMemberByName(String name) {
        return memberList.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addMember(Member member) {
        member.setMemberId(memberList.size() + 1);
        memberList.add(member);
    }

    public List<Member> getMemberAll() {
        return memberList;
    }

}
