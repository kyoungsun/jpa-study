package com.ksnote.jpastudy.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;



}
