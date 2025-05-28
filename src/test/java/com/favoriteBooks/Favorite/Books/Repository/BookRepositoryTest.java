package com.favoriteBooks.Favorite.Books.Repository;

import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthorDto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {

//    @Autowired
//    AuthorRepository authorRepository;
//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    EntityManager entityManager;

//    @Test
//    void findByAuthor_Id(Long id) {
//        AuthorDto author = new AuthorDto(1L,"marcos", "biografia");
//        entityManager.persist(author);
//        return author;
//    }
}