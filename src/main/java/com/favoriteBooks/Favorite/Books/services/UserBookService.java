package com.favoriteBooks.Favorite.Books.services;

import com.favoriteBooks.Favorite.Books.Repository.BookRepository;
import com.favoriteBooks.Favorite.Books.Repository.UserBookRepository;
import com.favoriteBooks.Favorite.Books.Repository.UserRepository;
import com.favoriteBooks.Favorite.Books.models.Book;
import com.favoriteBooks.Favorite.Books.models.User;
import com.favoriteBooks.Favorite.Books.models.UserBook;
import com.favoriteBooks.Favorite.Books.models.dtos.BookDto;
import com.favoriteBooks.Favorite.Books.models.dtos.UserBookDTO;
import com.favoriteBooks.Favorite.Books.models.dtos.UserBookResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserBookService {
    private final UserBookRepository userBookRepository;
    private final BookService bookService;

    public UserBookService(UserBookRepository userBookRepository, BookService bookService){
        this.userBookRepository = userBookRepository;
        this.bookService = bookService;
    }

    public UserBook createUserBook(@RequestBody UserBookDTO userBookDTO){
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserBook userBook = new UserBook();
        Book book = bookService.findBookById(userBookDTO.bookid());
        userBook.setBook(book);
        userBook.setUser(user);
        userBook.setId(userBookDTO.id());
        userBook.setBookRating(userBookDTO.rate());
        return userBookRepository.save(userBook);
    }

    public List<UserBook> findAllUserBooks(){
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserBookResponseDTO userBookResponseDTO = new UserBookResponseDTO();
        userBookResponseDTO.setUsername(user.getUsername());
        userBookResponseDTO.setId(user.getId());
        userBookResponseDTO.setUserBooks(user.getUserBooks());
        List<UserBook> userBookList = userBookRepository.findUserBookByUser(user);
        return userBookList;
    }
    public void deleteUserBookById(Long id){
        userBookRepository.deleteById(id);
    }
}
