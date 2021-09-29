package com.ksnote.jpastudy.member;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void 중복된_이메일이_없으면_회원가입_성공() {
        // given
        MemberCreateRequest request = MemberCreateRequest.builder()
                .name("홍길동")
                .build();
        // when
        memberService.createMember(request);
        // then
        verify(memberRepository, times(1)).save(any(Member.class));
    }

    @Test
    void 중복된_이메일이_있으면_오류_발생() {
        // given
        when(memberRepository.findByEmail(anyString())).thenReturn(anyList());
        MemberCreateRequest request = MemberCreateRequest.builder()
                .name("홍길동")
                .build();
        // when
        // then
        assertThatThrownBy(() -> {
            memberService.createMember(request);
        });
    }
}