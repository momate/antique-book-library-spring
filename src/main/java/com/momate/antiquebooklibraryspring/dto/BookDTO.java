package com.momate.antiquebooklibraryspring.dto;

import com.momate.antiquebooklibraryspring.model.Quality;
import com.momate.antiquebooklibraryspring.model.Reserved;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookDTO extends RepresentationModel<BookDTO> {

    private Long id;

    private String title;

    private String author;

    private String publisher;

    private LocalDate publishDate;

    private int pages;

    private Quality quality;

    private Reserved reserved;
}
