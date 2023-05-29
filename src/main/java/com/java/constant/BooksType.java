package com.java.constant;

public enum BooksType {

    ADVENTURE("ADV"),
    BIOGRAPHY_AND_AUTOBIOGRAPHY("BIO"),
    ROMANCE_AND_ROMANTIC_FICTION("ROM"),
    HORROR_AND_THRILLER("HOR");

    private String shortcut;

    BooksType(String shortcut) {
        this.shortcut = shortcut;
    }
}
