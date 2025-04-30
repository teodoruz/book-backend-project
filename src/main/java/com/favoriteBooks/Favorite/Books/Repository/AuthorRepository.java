package com.favoriteBooks.Favorite.Books.Repository;

import com.favoriteBooks.Favorite.Books.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByName(String name);
}
