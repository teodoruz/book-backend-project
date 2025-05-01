package com.favoriteBooks.Favorite.Books.services;

import com.favoriteBooks.Favorite.Books.Repository.AuthorRepository;
import com.favoriteBooks.Favorite.Books.controllers.exceptions.AuthorNotFind;
import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthorDto;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorAlreadyExists;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorListEmpty;
import org.hibernate.usertype.internal.AbstractTimeZoneStorageCompositeUserType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author insertAuthor(@RequestBody AuthorDto author) {
        Author authorcreated = new Author();
        this.toDto(author, authorcreated);
        if (authorRepository.existsByName(author.getName())) {
            throw new AuthorAlreadyExists("ja existe");
        }
        return authorRepository.save(authorcreated);
    }

    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authorList = authorRepository.findAll();
        if (authorList.isEmpty()) {
            throw new AuthorListEmpty("Lista de autores vazia");
        }
        return ResponseEntity.status(HttpStatus.OK).body(authorList);
    }

    public ResponseEntity<Author> getById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFind("Autor com o id: " + id + " Não encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    public void toDto(AuthorDto authorDto, Author author) {
        author.setName(authorDto.getName());
        author.setBiography(authorDto.getBiography());
    }


}
