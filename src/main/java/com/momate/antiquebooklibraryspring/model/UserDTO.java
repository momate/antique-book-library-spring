package com.momate.antiquebooklibraryspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    List<Reserved> reservedBooks;
}
