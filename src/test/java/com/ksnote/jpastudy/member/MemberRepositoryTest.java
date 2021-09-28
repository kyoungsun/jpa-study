package com.ksnote.jpastudy.member;

import com.ksnote.jpastudy.global.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

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

}