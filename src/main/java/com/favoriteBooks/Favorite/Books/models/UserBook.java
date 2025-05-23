package com.favoriteBooks.Favorite.Books.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.favoriteBooks.Favorite.Books.models.enums.BookRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idauthor_book")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idbook")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "iduser")
    @JsonBackReference
    private User user;
    @Enumerated(EnumType.STRING)
    private BookRating bookRating;

    public UserBook() {
    }

    public UserBook(Long id, Book book, User user, BookRating bookRating) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.bookRating = bookRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookRating getBookRating() {
        return bookRating;
    }

    public void setBookRating(BookRating bookRating) {
        this.bookRating = bookRating;
    }
}
