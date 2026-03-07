package com.harshit.SpringSecurity.BookSecurity.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String  title;

    private String author;

}
