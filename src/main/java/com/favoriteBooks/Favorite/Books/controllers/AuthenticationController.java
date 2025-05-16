package com.favoriteBooks.Favorite.Books.controllers;

import com.favoriteBooks.Favorite.Books.Repository.UserRepository;
import com.favoriteBooks.Favorite.Books.infra.security.TokenService;
import com.favoriteBooks.Favorite.Books.models.User;
import com.favoriteBooks.Favorite.Books.models.dtos.AuthenticationDto;
import com.favoriteBooks.Favorite.Books.models.dtos.LoginResponseDto;
import com.favoriteBooks.Favorite.Books.models.dtos.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto dto) {
        //criando um token a partir do login e da senha fornecidas pelo usuario
        var usernamepassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        //comparando o token gerado com as crecenciais salvas no banco de dados, e armazenando as informaçoes em uma var
        var auth = this.authenticationManager.authenticate(usernamepassword);
        //usa o tokenService para gerar um token com base nas informaçoes capturadas por auth.getPrincipal()
        var token = tokenService.generateToken((User) auth.getPrincipal());
        //retornando o token para autorizar requisiçoes
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO registerDTO) {
        //verificando se o usuario com o login fornecido ja existe no banco de dados
        if (userRepository.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().build();
        //encriptando criando um hash a senha fornecida pelo usuario
        String encriptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User user = new User(registerDTO.login(), encriptedPassword, registerDTO.role());
        this.userRepository.save(user);
        return ResponseEntity.ok().build();

    }
}
