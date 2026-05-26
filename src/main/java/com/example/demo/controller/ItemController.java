package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/items")
    public List<Item> search(@RequestParam String q) {
        return itemRepository.findByNameContaining(q);
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @PostConstruct
    public void init() {
        if (itemRepository.count() > 0) return;
        itemRepository.saveAll(List.of(
                Item.builder().name("강호성").description("MSP팀").build(),
                Item.builder().name("이해성").description("MSP팀").build(),
                Item.builder().name("최병주").description("SA팀").build(),
                Item.builder().name("홍이슬").description("운영팀").build(),
                Item.builder().name("장진환").description("대표이사").build()
        ));
    }
}
