package com.java.model;

import com.java.constant.ComicsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comics extends Document {

    private String title;
    private String content;
    private ComicsType comicsType;
    private Writer author;
    private Double price;

    public Comics(LocalDate publicationDate, String title, String content, ComicsType comicsType, Writer author, Double price) {
        super(publicationDate);
        this.title = title;
        this.content = content;
        this.comicsType = comicsType;
        this.author = author;
        this.price = price;
    }
}
