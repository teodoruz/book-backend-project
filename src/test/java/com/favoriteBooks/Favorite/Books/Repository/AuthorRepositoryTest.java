package com.favoriteBooks.Favorite.Books.Repository;

import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthorDto;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorAlreadyExists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    @DisplayName("buscando autor pelo nome existente com sucesso no banco de dados")
    void existsByName() {
        AuthorDto authorDto = new AuthorDto(null, "name", "bio");
        this.postAuthor(authorDto);
        authorRepository.existsByName(authorDto.getName());
    }


    void postAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setId(null);
        author.setName(authorDto.getName());
        author.setBiography(authorDto.getBiography());
        authorRepository.save(author);
    }

}