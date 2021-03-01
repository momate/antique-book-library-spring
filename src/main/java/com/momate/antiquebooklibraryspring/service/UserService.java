package com.momate.antiquebooklibraryspring.service;

import com.momate.antiquebooklibraryspring.dto.UserDTO;
import com.momate.antiquebooklibraryspring.model.User;

import java.util.List;

public interface UserService {

    boolean isEmailAlreadyInUse(String email);

    List<User> getAllUsers();

    User getUserById(Long id);

    UserDTO getUserByEmail(String email);

    User saveUser(UserDTO userDTO);

    User deleteUser(Long id);







}
