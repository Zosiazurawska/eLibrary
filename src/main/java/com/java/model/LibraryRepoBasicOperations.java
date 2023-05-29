package com.java.model;

public interface LibraryRepoBasicOperations {
    String save(Document document);
    String read(Document document);
    String delete(Document document);
}
