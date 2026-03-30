package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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
    

}
