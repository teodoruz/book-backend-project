package com.favoriteBooks.Favorite.Books.services.bookException;

public class BookNotExist extends RuntimeException {

    public BookNotExist(String message) {
        super(message);
    }
}
