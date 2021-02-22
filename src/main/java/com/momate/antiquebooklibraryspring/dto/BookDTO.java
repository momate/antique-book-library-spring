package com.momate.antiquebooklibraryspring.dto;

import com.momate.antiquebooklibraryspring.model.Quality;
import com.momate.antiquebooklibraryspring.model.Reserved;
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
