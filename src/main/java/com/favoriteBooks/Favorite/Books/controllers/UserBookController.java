package com.favoriteBooks.Favorite.Books.controllers;


import com.favoriteBooks.Favorite.Books.models.UserBook;
import com.favoriteBooks.Favorite.Books.models.dtos.UserBookDTO;
import com.favoriteBooks.Favorite.Books.services.UserBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/userbook")
public class UserBookController {
    private final UserBookService userBookService;
    public UserBookController(UserBookService userBookService){
        this.userBookService = userBookService;
    }
    @PostMapping
    public ResponseEntity<UserBook> createUserBook(@RequestBody UserBookDTO userBookDTO){
        UserBook userbookcreated = userBookService.createUserBook(userBookDTO);
        return ResponseEntity.ok().body(userbookcreated);
    }
}
