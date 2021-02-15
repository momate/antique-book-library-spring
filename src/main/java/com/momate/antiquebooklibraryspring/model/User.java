package com.momate.antiquebooklibraryspring.model;

import com.momate.antiquebooklibraryspring.util.EntitySuperClass;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User extends EntitySuperClass {

    @Column(unique = true, nullable = false)
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    @OneToMany(mappedBy = "user")
    List<Reserved> reservedBooks;

}
