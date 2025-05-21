package com.favoriteBooks.Favorite.Books.models.dtos;

import com.favoriteBooks.Favorite.Books.models.Author;
import com.favoriteBooks.Favorite.Books.models.enums.BookRating;
import lombok.Data;


public class BookDto {
    private Long id;
    private String title;
    private Long authorid;
    private BookRating bookRating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public BookRating getBookRating() {
        return bookRating;
    }

    public void setBookRating(BookRating bookRating) {
        this.bookRating = bookRating;
    }

    public Long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }
}
