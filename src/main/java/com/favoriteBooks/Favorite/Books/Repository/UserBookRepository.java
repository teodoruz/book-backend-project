package com.favoriteBooks.Favorite.Books.Repository;


import com.favoriteBooks.Favorite.Books.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {
}
