package com.example.librarysec.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Book {
    String title;
    String author;
    int year;
}

