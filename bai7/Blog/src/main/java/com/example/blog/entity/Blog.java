package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tieuDe;

    @Column(columnDefinition = "TEXT")
    private String tomTat;

    @Column(columnDefinition = "TEXT")
    private String noiDung;

    private String tacGia;

    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}