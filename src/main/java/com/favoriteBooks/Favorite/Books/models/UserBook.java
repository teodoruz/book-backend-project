package com.favoriteBooks.Favorite.Books.models;

import jakarta.persistence.*;

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
    private User user;
    private String rate;
    private String note;

}
