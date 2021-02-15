package com.momate.antiquebooklibraryspring.model;

import com.momate.antiquebooklibraryspring.util.EntitySuperClass;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Book extends EntitySuperClass {

    private String title;
    private String author;
    private String publisher;
    private LocalDate publishDate;
    private int pages;
    private String quality;
    @OneToOne(mappedBy = "book")
    private Reserved reserved;

}
