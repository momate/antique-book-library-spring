package com.momate.antiquebooklibraryspring.util;

import com.momate.antiquebooklibraryspring.dto.BookDTO;
import com.momate.antiquebooklibraryspring.dto.UserDTO;
import com.momate.antiquebooklibraryspring.model.Book;
import com.momate.antiquebooklibraryspring.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public Book bookDtoToEntity(BookDTO dto){
        return modelMapper().map(dto,Book.class);
    }

    public BookDTO bookEntityToBookDto(Book entity){
        return modelMapper().map(entity,BookDTO.class);
    }

    public User userDtoToEntity(UserDTO dto){
        return modelMapper().map(dto,User.class);
    }

    public UserDTO userEntityToUserDto(User entity){
        return modelMapper().map(entity, UserDTO.class);
    }
}
