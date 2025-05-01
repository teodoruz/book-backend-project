package com.favoriteBooks.Favorite.Books.controllers.exceptions;

public class AuthorNotFind extends RuntimeException {

    public AuthorNotFind(String message) {
        super(message);
    }
}
