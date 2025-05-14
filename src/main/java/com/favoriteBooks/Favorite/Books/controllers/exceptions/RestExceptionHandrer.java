package com.favoriteBooks.Favorite.Books.controllers.exceptions;

import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.enums.BookRating;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorAlreadyExists;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorListEmpty;
import com.favoriteBooks.Favorite.Books.services.authorException.AuthorNotFind;
import com.favoriteBooks.Favorite.Books.services.bookException.BookNotExist;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandrer extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthorAlreadyExists.class)
    public ResponseEntity<StandardError> authorAlreadyExistsResponseEntity(AuthorAlreadyExists a, HttpServletRequest request) {
        HttpStatus status = HttpStatus.MULTIPLE_CHOICES;
        String error = "Usuario ja existe no banco de dados";
        StandardError standardError = new StandardError(Instant.now().toString(), error, a.getMessage(), request.getRequestURI(), status.toString());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(AuthorListEmpty.class)
    public ResponseEntity<StandardError> authorListIsEmpty(AuthorListEmpty a, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Alista esta vazia";
        StandardError standardError = new StandardError(Instant.now().toString(), status.toString(), error, a.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException c, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Atributo em branco";
        StandardError standardError = new StandardError(Instant.now().toString(), status.toString(), error, c.getMessage(), request.getContextPath());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(AuthorNotFind.class)
    public ResponseEntity<StandardError> authorNotFind(AuthorNotFind a, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Autor não encontrado";
        StandardError standardError = new StandardError(Instant.now().toString(), status.toString(), error, a.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(BookNotExist.class)
    public ResponseEntity<StandardError> bookNotExist(BookNotExist b, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "este livro não existe";
        StandardError standardError = new StandardError(Instant.now().toString(), error, status.toString(), b.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
