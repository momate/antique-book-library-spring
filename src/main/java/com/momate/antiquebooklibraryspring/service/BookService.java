package com.momate.antiquebooklibraryspring.service;

import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.dto.BookDTO;
import com.momate.antiquebooklibraryspring.model.Quality;

import java.time.LocalDate;
import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    List<BookDTO> getBooksByAuthor(String author);

    List<BookDTO> getBooksByPublisher(String publisher);

    List<BookDTO> getBooksByPublishDate(LocalDate publishDate);

    List<BookDTO> getBooksByQuality(Quality quality);

    BookDTO getBookById(Long id);

    Book saveBook(BookDTO bookDTO);

    void deleteBook(BookDTO bookDTO);


}
