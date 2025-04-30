package com.favoriteBooks.Favorite.Books.Repository;

import com.favoriteBooks.Favorite.Books.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
