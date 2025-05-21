package com.favoriteBooks.Favorite.Books.controllers;


import com.favoriteBooks.Favorite.Books.models.User;
import com.favoriteBooks.Favorite.Books.models.UserBook;
import com.favoriteBooks.Favorite.Books.models.dtos.UserBookDTO;
import com.favoriteBooks.Favorite.Books.services.UserBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<UserBook>> findAllUserBooks(){
        List<UserBook> userBookList = userBookService.findAllUserBooks();
        return ResponseEntity.ok().body(userBookList);
    }
    @DeleteMapping
    public void deleteUserBookById(@RequestParam Long id){
        userBookService.deleteUserBookById(id);
    }
}
