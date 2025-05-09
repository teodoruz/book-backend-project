package com.favoriteBooks.Favorite.Books.models.dtos;

import com.favoriteBooks.Favorite.Books.models.enums.UserRoles;

public record RegisterDTO(String login, String password, UserRoles role) {
}
