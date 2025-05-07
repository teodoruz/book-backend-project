package com.favoriteBooks.Favorite.Books.services.authorException;

public class AuthorNotFind extends RuntimeException {

    public AuthorNotFind(String message) {
        super(message);
    }

}
