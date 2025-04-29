package com.favoriteBooks.Favorite.Books.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

//pascal case
@Entity
public class Author {
    //camel case
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idauthor")
    private Long id;
    private String name;
    private String biography;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "Books")
    private List<Book> books;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
