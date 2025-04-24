package com.favoriteBooks.Favorite.Books.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(){}

    public Book(Long id, String title, Author author){
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
