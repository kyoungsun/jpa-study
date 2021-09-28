package com.ksnote.jpastudy.global.model;

import lombok.*;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Address {

    private String city;
    private String street;
    private String zipcode;

    @Builder
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
