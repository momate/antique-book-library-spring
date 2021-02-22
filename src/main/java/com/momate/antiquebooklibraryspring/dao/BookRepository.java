package com.momate.antiquebooklibraryspring.dao;

import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.model.Quality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByPublishDate(LocalDate publishDate);

    List<Book> findAllByPublisher(String publisher);

    List<Book> findAllByQuality(Quality quality);

}
