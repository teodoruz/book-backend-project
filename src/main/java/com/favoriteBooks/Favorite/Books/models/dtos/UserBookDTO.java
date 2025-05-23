package com.favoriteBooks.Favorite.Books.models.dtos;

import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.User;
import com.favoriteBooks.Favorite.Books.models.enums.BookRating;

public record UserBookDTO(Long id, Long bookid, BookRating rate) {
}
