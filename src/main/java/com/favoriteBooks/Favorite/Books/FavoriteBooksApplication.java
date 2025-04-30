package com.favoriteBooks.Favorite.Books;

import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthorDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FavoriteBooksApplication {

    public static void main(String[] args) {
        AuthorDto authorDto = new AuthorDto(1L, "marcos", "aaa");
        SpringApplication.
                run(FavoriteBooksApplication.class, args);


    }

}
