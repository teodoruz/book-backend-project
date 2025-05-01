package com.favoriteBooks.Favorite.Books.services.authorException;

public class AuthorListEmpty extends RuntimeException {

    public AuthorListEmpty(String message) {
        super(message);
    }
}
