package com.momate.antiquebooklibraryspring.util;

import com.momate.antiquebooklibraryspring.controller.BookController;
import com.momate.antiquebooklibraryspring.dto.BookDTO;
import com.momate.antiquebooklibraryspring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.ArrayList;
import java.util.List;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, BookDTO>{

    @Autowired
    private ModelConverter modelConverter;


    @Override
    public BookDTO toModel(Book entity) {

        BookDTO bookDTO = modelConverter.bookEntityToBookDto(entity);

        Link selfLink = linkTo(methodOn(BookController.class).getBookById(entity.getId())).withSelfRel();
        bookDTO.add(selfLink);

        return bookDTO;
    }

    @Override
    public CollectionModel<BookDTO> toCollectionModel(Iterable<? extends Book> entities) {

        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : entities){
            BookDTO bookDTO = modelConverter.bookEntityToBookDto(book);
            bookDTO.add(linkTo(methodOn(BookController.class)
                    .getBookById(bookDTO.getId())).withSelfRel());
            bookDTOS.add(bookDTO);
        }

        return new CollectionModel<>(bookDTOS);
    }
}
