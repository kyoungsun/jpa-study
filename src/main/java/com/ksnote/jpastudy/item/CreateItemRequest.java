package com.ksnote.jpastudy.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateItemRequest {

    private String name;
    private int price;
    private int stockQuantity;

    @Builder
    private CreateItemRequest(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }
}
