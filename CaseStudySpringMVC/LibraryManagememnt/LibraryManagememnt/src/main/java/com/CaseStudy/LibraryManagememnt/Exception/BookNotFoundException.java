package com.CaseStudy.LibraryManagememnt.Exception;
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}