package com.favoriteBooks.Favorite.Books.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


public class AuthorDto {
    private Long id;
    private String name;
    private String biography;

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public AuthorDto() {

    }

    public AuthorDto(Long id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }
}
