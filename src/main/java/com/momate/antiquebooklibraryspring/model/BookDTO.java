package com.momate.antiquebooklibraryspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookDTO {

    private String title;

    private String author;

    private String publisher;

    private LocalDate publishDate;

    private int pages;

    private Quality quality;

    private Reserved reserved;
}
