package com.ksnote.jpastudy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMember(MemberCreateRequest request) {
        return memberRepository.save(request.toEntity());
    }

}
