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
        // 데이터가 이미 있으면 초기화 건너뜀
        // 테이블 삭제 후 재배포 시 자동으로 데이터 채워짐
        if (itemRepository.count() > 0) return;

        itemRepository.saveAll(List.of(
                // 경영진
                Item.builder().name("장진환").description("CEO").build(),
                Item.builder().name("민재열").description("CTO").build(),
                Item.builder().name("김지훈").description("COO").build(),

                // SA Team
                Item.builder().name("곽호상").description("SA팀").build(),
                Item.builder().name("한현성").description("SA팀").build(),
                Item.builder().name("이원조").description("SA팀").build(),
                Item.builder().name("이의주").description("SA팀").build(),
                Item.builder().name("김병덕").description("SA팀").build(),
                Item.builder().name("김두영").description("SA팀").build(),
                Item.builder().name("최병주").description("SA팀").build(),

                // MSP Team
                Item.builder().name("조만희").description("MSP팀").build(),
                Item.builder().name("윤현동").description("MSP팀").build(),
                Item.builder().name("이지현").description("MSP팀").build(),
                Item.builder().name("김창희").description("MSP팀").build(),
                Item.builder().name("이해성").description("MSP팀").build(),
                Item.builder().name("윤현찬").description("MSP팀").build(),
                Item.builder().name("김민정").description("MSP팀").build(),
                Item.builder().name("서건혁").description("MSP팀").build(),
                Item.builder().name("강호성").description("MSP팀").build(),
                Item.builder().name("박세진").description("MSP팀").build(),
                Item.builder().name("송재훈").description("MSP팀").build(),
                Item.builder().name("김기수").description("MSP팀").build(),

                // Web Dev Team
                Item.builder().name("서재영").description("Web Dev팀").build(),
                Item.builder().name("정은주").description("Web Dev팀").build(),
                Item.builder().name("김정수").description("Web Dev팀").build(),

                // Sales 1 Team
                Item.builder().name("송태준").description("Sales 1팀").build(),
                Item.builder().name("이수아").description("Sales 1팀").build(),
                Item.builder().name("정희경").description("Sales 1팀").build(),
                Item.builder().name("장정빈").description("Sales 1팀").build(),

                // Sales 2 Team
                Item.builder().name("전철용").description("Sales 2팀").build(),
                Item.builder().name("이민재").description("Sales 2팀").build(),
                Item.builder().name("박준홍").description("Sales 2팀").build(),
                Item.builder().name("류민우").description("Sales 2팀").build(),
                Item.builder().name("오수정").description("Sales 2팀").build(),

                // BDR Team
                Item.builder().name("최채은").description("BDR팀").build(),
                Item.builder().name("권지연").description("BDR팀").build(),
                Item.builder().name("정연주").description("BDR팀").build(),

                // Brand Team
                Item.builder().name("윤효정").description("Brand팀").build(),
                Item.builder().name("류은진").description("Brand팀").build(),
                Item.builder().name("전은민").description("Brand팀").build(),

                // Partner Team
                Item.builder().name("김무원").description("Partner팀").build(),
                Item.builder().name("차민혁").description("Partner팀").build(),
                Item.builder().name("류예지").description("Partner팀").build(),
                Item.builder().name("정영식").description("Partner팀").build(),

                // Admin Team
                Item.builder().name("홍이슬").description("Admin팀").build(),
                Item.builder().name("윤가은").description("Admin팀").build(),

                // Operation Team
                Item.builder().name("박종호").description("Operation팀").build(),
                Item.builder().name("서동호").description("Operation팀").build(),
                Item.builder().name("주지현").description("Operation팀").build(),
                Item.builder().name("이태준").description("Operation팀").build(),
                Item.builder().name("임민영").description("Operation팀").build(),
                Item.builder().name("손진영").description("Operation팀").build(),
                Item.builder().name("전혜진").description("Operation팀").build()
        ));
    }
}
