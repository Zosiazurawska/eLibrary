package com.java.model;

import com.java.constant.BooksType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Document {

    private String title;
    private String content;
    private BooksType bookType;
    private Writer author;
    private Double price;

    public Book(LocalDate publicationDate, String title, String content, BooksType bookType, Writer author, Double price) {
        super(publicationDate);
        this.title = title;
        this.content = content;
        this.bookType = bookType;
        this.author = author;
        this.price = price;
    }
}
