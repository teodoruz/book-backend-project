package com.favoriteBooks.Favorite.Books.services;

import com.favoriteBooks.Favorite.Books.Repository.AuthorRepository;
import com.favoriteBooks.Favorite.Books.Repository.BookRepository;
import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.dtos.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Book postBook(@RequestBody BookDto bookDto) {
        Book book = new Book();
        this.toDto(bookDto, book);
        Long authorid = bookDto.getAuthor().getId();
        ResponseEntity<Author> author = authorService.getById(authorid);
        bookDto.setAuthor(author.getBody());
        return bookRepository.save(book);

    }

    public void toDto(BookDto bookDto, Book book) {
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setBookRating(bookDto.getBookRating());
    }
}
