package com.favoriteBooks.Favorite.Books.models.enums;

public enum UserRoles {
    //tipos de usuario
    ADMIN("admin"),
    USER("user");

    private String role;


    //construir uma role
    UserRoles(String role) {
        this.role = role;
    }


    //pegar a role
    public String getRole() {
        return role;
    }
}
