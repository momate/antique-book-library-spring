package com.momate.antiquebooklibraryspring.dto;

import com.momate.antiquebooklibraryspring.model.Reserved;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO extends RepresentationModel<UserDTO> {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    List<Reserved> reservedBooks;
}
