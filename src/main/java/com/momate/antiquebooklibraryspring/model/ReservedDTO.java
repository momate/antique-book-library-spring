package com.momate.antiquebooklibraryspring.model;

import java.time.LocalDateTime;

public class ReservedDTO {

    private Long id;
    private Book book;
    private User user;
    private LocalDateTime reservationDate;
    private LocalDateTime expirationDate;
}
