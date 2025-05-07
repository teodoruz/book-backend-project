package com.favoriteBooks.Favorite.Books.services;

import com.favoriteBooks.Favorite.Books.Repository.AuthorRepository;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorNotFind;
import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthorDto;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorAlreadyExists;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorListEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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

    public Author getById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFind("Autor com o id: " + id + " Não encontrado"));
        return author;
    }

    public void deleteAuthor(@PathVariable Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new AuthorNotFind("autor com id " + " não encontrado");
        }
    }

    public void toDto(AuthorDto authorDto, Author author) {
        author.setName(authorDto.getName());
        author.setBiography(authorDto.getBiography());
    }


}
