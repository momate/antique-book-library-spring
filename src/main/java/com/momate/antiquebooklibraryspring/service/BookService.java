package com.momate.antiquebooklibraryspring.service;

import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.dto.BookDTO;
import com.momate.antiquebooklibraryspring.model.Quality;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByPublisher(String publisher);

    List<Book> getBooksByPublishDate(LocalDate publishDate);

    List<Book> getBooksByQuality(Quality quality);

    Optional<Book> getBookById(Long id);

    Book saveBook(BookDTO bookDTO);

    void deleteBook(BookDTO bookDTO);


}
