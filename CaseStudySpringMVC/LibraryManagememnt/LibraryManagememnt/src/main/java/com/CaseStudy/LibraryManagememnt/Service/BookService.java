package com.CaseStudy.LibraryManagememnt.Service;

import com.CaseStudy.LibraryManagememnt.Exception.BookNotFoundException;
import com.CaseStudy.LibraryManagememnt.Model.Book;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }
    public List<Book> viewAllBooks(){
        return books;
    }

    public  Book getBookById(int id){
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(()->new BookNotFoundException("Book with id: "+ id+" not found"));
    }
    public void deleteBook(int id) {
        Book book = getBookById(id);
        books.remove(book);
    }
}
