package com.favoriteBooks.Favorite.Books.services.authorException;

public class AuthorAlreadyExists extends RuntimeException {

    public AuthorAlreadyExists(String message) {
        super(message);
    }
}
