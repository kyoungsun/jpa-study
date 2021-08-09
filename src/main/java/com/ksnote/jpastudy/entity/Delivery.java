package com.ksnote.jpastudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Builder
    public Delivery(Order order, String city, String street, String zipcode, DeliveryStatus status) {
        this.order = order;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = status;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
