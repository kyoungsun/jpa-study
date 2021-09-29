package com.ksnote.jpastudy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(MemberCreateRequest request) {
        List<Member> members = memberRepository.findByEmail(request.getEmail());
        if (!members.isEmpty()) {
            throw new RuntimeException("중복된 이메일이 존재합니다.");
        }

        return memberRepository.save(request.toEntity());
    }

}
