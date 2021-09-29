package com.ksnote.jpastudy.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Long createItem(CreateItemRequest request) {
        Item item = itemRepository.save(request.toEntity());
        return item.getId();
    }

}
