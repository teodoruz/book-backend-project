package com.favoriteBooks.Favorite.Books.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauthor")
    @Id
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String biography;
    @OneToMany
    @JsonIgnore
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
