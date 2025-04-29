package com.favoriteBooks.Favorite.Books.Repository;

import com.favoriteBooks.Favorite.Books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
