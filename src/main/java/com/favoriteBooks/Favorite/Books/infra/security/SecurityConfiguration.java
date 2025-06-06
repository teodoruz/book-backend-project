package com.favoriteBooks.Favorite.Books.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//habilianto configuração personalizada para o web security
@EnableWebSecurity
public class SecurityConfiguration {

    private final SecurityFilter securityFilter;
    public SecurityConfiguration(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //desabilitando a autenticação do tipo csrf, pois não vou lidar com sessões
                .csrf(csrf -> csrf.disable())
                //indicando que aplicação vai usar STATELESS, ou seja, utilizará tokens jwt e não sessoes
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //indicando quem vai acessar quais rotas, neste exemplo, somente ADMIN poderá acessar /author post
                .authorizeHttpRequests(authorize -> authorize
                        //permite acesso livre sem autenticação a rota de login
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/author").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/userbook").authenticated()
                        .requestMatchers(HttpMethod.POST, "/book").authenticated()
                        .requestMatchers(HttpMethod.GET, "/book").authenticated()
                        .requestMatchers(HttpMethod.GET, "/author").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/userbook").authenticated()
                        .requestMatchers(HttpMethod.GET, "/author/{id}/books").authenticated()
                        .requestMatchers(HttpMethod.GET, "/userbook").authenticated()
                        //indicando que qualquer outra requisição precisa estar autenticada para acessar
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    //metodo para gerar um hash da senha (será salva no banco de dados)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
