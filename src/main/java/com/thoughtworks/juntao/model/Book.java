package com.thoughtworks.juntao.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;

    public Book() {
        title = "default";
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
