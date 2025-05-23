package com.favoriteBooks.Favorite.Books.Repository;


import com.favoriteBooks.Favorite.Books.models.User;
import com.favoriteBooks.Favorite.Books.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {
    List<UserBook> findUserBookByUser(User user);
}
