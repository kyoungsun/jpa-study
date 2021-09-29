package com.ksnote.jpastudy.member;

import com.ksnote.jpastudy.global.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 회원_조회() {
        // given
        String name = "홍길동";
        Address address = Address.builder()
                .city("서울특별시")
                .street("구로구")
                .zipcode("08378")
                .build();
        Member request = entityManager.persist(Member.builder()
                .name(name)
                .address(address)
                .build());
        // when
        Member member = memberRepository.findById(request.getId()).get();
        // then
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getAddress()).isEqualTo(address);
    }

    @Test
    void 회원_이메일로_조회() {
        // given
        String name = "홍길동";
        String email = "hong@test.com";
        Address address = Address.builder()
                .city("서울특별시")
                .street("구로구")
                .zipcode("08378")
                .build();
        Member request = entityManager.persist(Member.builder()
                .name(name)
                .email(email)
                .address(address)
                .build());
        // when
        List<Member> members = memberRepository.findByEmail(email);
        // then
        assertThat(members.get(0).getEmail()).isEqualTo(email);
    }

}