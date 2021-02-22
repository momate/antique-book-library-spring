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
    public List<BookDTO> getAllBooks() {
        List<Book> bookEntitiesList = null;
        List<BookDTO> bookDTOList = new ArrayList<>();

        bookEntitiesList = bookRepository.findAll();

        if(bookEntitiesList != null){
            for (Book b : bookEntitiesList){
                bookDTOList.add(modelConverter.bookEntityToBookDto(b));
            }
        }

        return bookDTOList;
    }

    @Override
    public List<BookDTO> getBooksByAuthor(String author) {
        List<Book> bookEntitiesList = null;
        List<BookDTO> bookDTOList = new ArrayList<>();

        bookEntitiesList = bookRepository.findAll();

        if(bookEntitiesList != null){
            for (Book b : bookEntitiesList){
                bookDTOList.add(modelConverter.bookEntityToBookDto(b));
            }
        }

        return bookDTOList;
    }

    @Override
    public List<BookDTO> getBooksByPublisher(String publisher) {
        List<Book> bookEntitiesList = null;
        List<BookDTO> bookDTOList = new ArrayList<>();

        bookEntitiesList = bookRepository.findAllByPublisher(publisher);

        if(bookEntitiesList != null){
            for (Book b : bookEntitiesList){
                bookDTOList.add(modelConverter.bookEntityToBookDto(b));
            }
        }

        return bookDTOList;
    }

    @Override
    public List<BookDTO> getBooksByPublishDate(LocalDate publishDate) {
        List<Book> bookEntitiesList = null;
        List<BookDTO> bookDTOList = new ArrayList<>();

        bookEntitiesList = bookRepository.findAllByPublishDate(publishDate);

        if(bookEntitiesList != null){
            for (Book b : bookEntitiesList){
                bookDTOList.add(modelConverter.bookEntityToBookDto(b));
            }
        }

        return bookDTOList;
    }

    @Override
    public List<BookDTO> getBooksByQuality(Quality quality) {
        List<Book> bookEntitiesList = null;
        List<BookDTO> bookDTOList = new ArrayList<>();

        bookEntitiesList = bookRepository.findAllByQuality(quality);

        if(bookEntitiesList != null){
            for (Book b : bookEntitiesList){
                bookDTOList.add(modelConverter.bookEntityToBookDto(b));
            }
        }

        return bookDTOList;
    }

    @Override
    public BookDTO getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        BookDTO bookDTO = new BookDTO();

        if (book.isPresent()){
            bookDTO = modelConverter.bookEntityToBookDto(book.get());
        }

        return bookDTO;
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Book book = null;

        if(bookDTO != null){
             book = modelConverter.bookDtoToEntity(bookDTO);
        }
        bookRepository.save(book);

        return book;

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
