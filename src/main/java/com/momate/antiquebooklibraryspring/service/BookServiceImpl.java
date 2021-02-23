package com.momate.antiquebooklibraryspring.service;



import com.momate.antiquebooklibraryspring.dao.BookRepository;
import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.dto.BookDTO;
import com.momate.antiquebooklibraryspring.model.Quality;
import com.momate.antiquebooklibraryspring.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelConverter modelConverter;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        if(books.isEmpty()){
            books = new ArrayList<>();
        }

       return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        List<Book> bookEntitiesList  = bookRepository.findAll();
        return bookEntitiesList;
    }

    @Override
    public List<Book> getBooksByPublisher(String publisher) {
        List<Book> bookEntitiesList = bookRepository.findAllByPublisher(publisher);

        return bookEntitiesList;
    }

    @Override
    public List<Book> getBooksByPublishDate(LocalDate publishDate) {
        List<Book> bookEntitiesList = bookRepository.findAllByPublishDate(publishDate);

        return bookEntitiesList;
    }

    @Override
    public List<Book> getBooksByQuality(Quality quality) {
        List<Book> bookEntitiesList  = bookRepository.findAllByQuality(quality);

        return bookEntitiesList;
    }

    @Override
    public Optional<Book> getBookById(Long id) {

        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Book book = modelConverter.bookDtoToEntity(bookDTO);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(BookDTO bookDTO) {
        Book book = null;
        if(bookDTO != null){
            book = modelConverter.bookDtoToEntity(bookDTO);
        }
        bookRepository.delete(book);
    }
}
