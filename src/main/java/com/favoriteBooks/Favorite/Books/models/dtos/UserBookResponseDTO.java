package com.favoriteBooks.Favorite.Books.models.dtos;

import com.favoriteBooks.Favorite.Books.models.UserBook;

import java.util.List;

public class UserBookResponseDTO{
    private Long id;
    private String username;
    private List<UserBook> userBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<UserBook> userBooks) {
        this.userBooks = userBooks;
    }
}
