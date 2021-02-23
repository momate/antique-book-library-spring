package com.momate.antiquebooklibraryspring.controller;

import com.momate.antiquebooklibraryspring.dto.BookDTO;
import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.service.BookService;
import com.momate.antiquebooklibraryspring.util.BookModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookModelAssembler bookModelAssembler;

    @GetMapping
    public CollectionModel<BookDTO> getAllBooks(){
        List<Book> bookList = bookService.getAllBooks();
        return bookModelAssembler.toCollectionModel(bookList);
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return bookModelAssembler.toModel(book.get());

    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO){
        if (bookDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Book book = bookService.saveBook(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }


}
