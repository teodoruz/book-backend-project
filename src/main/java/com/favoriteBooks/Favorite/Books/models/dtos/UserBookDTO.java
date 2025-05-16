package com.favoriteBooks.Favorite.Books.models.dtos;

import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.User;

public record UserBookDTO(Long id, Book book, User user, String rate) {
}
