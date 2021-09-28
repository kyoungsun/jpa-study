package com.ksnote.jpastudy.member;

import com.ksnote.jpastudy.global.model.Address;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCreateRequest {

    private String name;
    private String email;
    private String city;
    private String street;
    private String zipcode;

    @Builder
    private MemberCreateRequest(String name, String email, String city, String street, String zipcode) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .address(Address.builder()
                        .city(city)
                        .street(street)
                        .zipcode(zipcode)
                        .build())
                .build();
    }
}
