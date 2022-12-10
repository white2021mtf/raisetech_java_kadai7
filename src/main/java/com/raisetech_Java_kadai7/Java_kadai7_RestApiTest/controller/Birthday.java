package com.raisetech_Java_kadai7.Java_kadai7_RestApiTest.controller;

public class Birthday {
    private final String birthday;

    public Birthday(String birthday) {
        this.birthday = birthday;
    }

    public String getContent() {
        return birthday;
    }
}