package com.favoriteBooks.Favorite.Books.controllers;

import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.dtos.BookDto;
import com.favoriteBooks.Favorite.Books.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deleteBookCreated(@PathVariable Long id) {
        bookService.deleteBookCreated(id);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> books =bookService.findAllBooks();
        return ResponseEntity.ok().body(books);
    }


}
