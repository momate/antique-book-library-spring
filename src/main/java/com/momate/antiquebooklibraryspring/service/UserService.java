package com.momate.antiquebooklibraryspring.service;

import com.momate.antiquebooklibraryspring.dto.UserDTO;
import com.momate.antiquebooklibraryspring.model.User;

import java.util.List;

public interface UserService {

    boolean isEmailAlreadyInUse(String email);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO getUserByEmail(String email);

    User saveUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);







}
