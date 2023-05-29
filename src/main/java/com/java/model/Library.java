package com.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library implements LibraryRepoBasicOperations {

    private String city;
    private Integer maxBookAmount;
    private List<Document> documents;

    @Override
    public String save(Document document) {
        if (documents.size() == maxBookAmount) {
            return "There is no more space for another book!";
        } else {
            documents.add(document);
            return "Document added successfully!";
        }
    }

    @Override
    public String read(Document document) {
        if (!documents.contains(document)) {
            return "There is no such document in the library!";
        } else {
            return document.toString().toUpperCase();
        }
    }

    @Override
    public String delete(Document document) {
        if (!documents.contains(document)) {
            return "There is no such document in the library!";
        } else {
            documents.remove(document);
            return "Document deleted successfully!";
        }
    }
}
