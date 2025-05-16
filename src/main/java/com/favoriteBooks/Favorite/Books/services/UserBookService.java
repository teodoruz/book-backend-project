package com.favoriteBooks.Favorite.Books.services;

import com.favoriteBooks.Favorite.Books.Repository.UserBookRepository;
import com.favoriteBooks.Favorite.Books.models.User;
import com.favoriteBooks.Favorite.Books.models.UserBook;
import com.favoriteBooks.Favorite.Books.models.dtos.UserBookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserBookService {
    private final UserBookRepository userBookRepository;

    public UserBookService(UserBookRepository userBookRepository){
        this.userBookRepository = userBookRepository;
    }

    public ResponseEntity<UserBook> createUserBook(@RequestBody UserBookDTO userBookDTO){
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserBook userBook = new UserBook();
        userBook.setBook(userBookDTO.book());
        userBook.setUser(user);
        userBook.setId(userBookDTO.id());
        userBook.setBookRating(userBook.getBookRating());
        UserBook userBook1 = userBookRepository.save(userBook);
        return ResponseEntity.ok().body(userBook1);
    }
}
