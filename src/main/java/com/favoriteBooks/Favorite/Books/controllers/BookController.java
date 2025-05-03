package com.favoriteBooks.Favorite.Books.controllers;

import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.dtos.BookDto;
import com.favoriteBooks.Favorite.Books.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book postBook(@RequestBody BookDto bookDto) {
        return bookService.postBook(bookDto);
    }


}
