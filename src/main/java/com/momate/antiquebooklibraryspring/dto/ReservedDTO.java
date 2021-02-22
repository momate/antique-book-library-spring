package com.momate.antiquebooklibraryspring.dto;

import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.model.User;

import java.time.LocalDateTime;

public class ReservedDTO {

    private Long id;
    private Book book;
    private User user;
    private LocalDateTime reservationDate;
    private LocalDateTime expirationDate;
}
