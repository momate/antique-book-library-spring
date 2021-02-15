package com.momate.antiquebooklibraryspring.dao;

import com.momate.antiquebooklibraryspring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Long, Book> {
}
