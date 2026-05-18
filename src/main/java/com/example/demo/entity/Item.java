package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "items")
@Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}