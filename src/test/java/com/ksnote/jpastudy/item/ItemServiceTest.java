package com.ksnote.jpastudy.item;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemService itemService;

    @Test
    void 아이템_생성() {
        // given
        when(itemRepository.save(any(Item.class))).then(returnsFirstArg());
        CreateItemRequest request = CreateItemRequest.builder()
                .name("아이템1")
                .price(1000)
                .stockQuantity(10)
                .build();
        // when
        itemService.createItem(request);
        // then
        verify(itemRepository, times(1)).save(any(Item.class));
    }
}