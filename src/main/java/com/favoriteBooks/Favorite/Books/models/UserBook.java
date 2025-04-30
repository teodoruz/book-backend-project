package com.favoriteBooks.Favorite.Books.models;

import com.favoriteBooks.Favorite.Books.models.enums.BookRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idauthor_book")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idbook")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    private BookRating bookRating;

}
