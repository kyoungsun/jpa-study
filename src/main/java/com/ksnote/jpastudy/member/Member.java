package com.ksnote.jpastudy.member;

import com.ksnote.jpastudy.global.model.Address;
import com.ksnote.jpastudy.domain.demo.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private String email;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    private Member(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

}
