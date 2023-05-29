package com.java.constant;

public enum ComicsType {

    SCIENCE_FICTION("SF"),
    FANTASY("FAN"),
    CRIME_STORY("CRI");
    private String shortcut;

    ComicsType(String shortcut) {
        this.shortcut = shortcut;
    }
}
