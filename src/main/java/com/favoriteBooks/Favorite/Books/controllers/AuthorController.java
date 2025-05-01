package com.favoriteBooks.Favorite.Books.controllers;

import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthorDto;
import com.favoriteBooks.Favorite.Books.services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> postAuthor(@RequestBody AuthorDto authordto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.insertAuthor(authordto));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        return authorService.getById(id);
    }
    
}
