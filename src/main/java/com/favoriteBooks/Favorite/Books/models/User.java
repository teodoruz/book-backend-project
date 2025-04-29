package com.favoriteBooks.Favorite.Books.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserBook> userBooks;
}
