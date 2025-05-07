package com.favoriteBooks.Favorite.Books.services;

import com.favoriteBooks.Favorite.Books.Repository.BookRepository;
import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.dtos.BookDto;
import com.favoriteBooks.Favorite.Books.services.bookException.BookNotExist;
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
        Author author = authorService.getById(bookDto.getAuthor().getId());
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(author);
        book.setBookRating(bookDto.getBookRating());
        return bookRepository.save(book);
    }

    public void deleteBookCreated(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotExist("autor de id " + id + " não existe");
        }
    }

    public void toDto(BookDto bookDto, Book book) {
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setBookRating(bookDto.getBookRating());
    }
}
