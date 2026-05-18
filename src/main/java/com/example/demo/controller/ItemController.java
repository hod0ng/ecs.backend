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
                Item.builder().name("노트북").description("삼성 갤럭시북").build(),
                Item.builder().name("마우스").description("로지텍 무선 마우스").build(),
                Item.builder().name("키보드").description("기계식 키보드").build(),
                Item.builder().name("모니터").description("27인치 4K 디스플레이").build(),
                Item.builder().name("이어폰").description("애플 에어팟").build()
        ));
    }
}