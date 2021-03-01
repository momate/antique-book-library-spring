package com.momate.antiquebooklibraryspring.service;

import com.momate.antiquebooklibraryspring.dao.UserRepository;
import com.momate.antiquebooklibraryspring.dto.UserDTO;
import com.momate.antiquebooklibraryspring.exception.BookNotFoundException;
import com.momate.antiquebooklibraryspring.exception.UserNotFoundException;
import com.momate.antiquebooklibraryspring.model.User;
import com.momate.antiquebooklibraryspring.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelConverter modelConverter;

    @Override
    public boolean isEmailAlreadyInUse(String email) {
        if (getUserByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        if(users.isEmpty()){
            users = new ArrayList<>();
        }

        return users;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> book =  userRepository.findById(id);

        if(book.isPresent()){
            return book.get();
        }

        throw new UserNotFoundException("User not found with ID: " + id);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        UserDTO userDTO = null;
        userDTO = modelConverter.userEntityToUserDto(userRepository.findUserByEmail(email));

        return userDTO;
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = null;
        if(userDTO != null){
            user = modelConverter.userDtoToEntity(userDTO);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return user.get();
        }else{
            throw new BookNotFoundException("User not found with ID: " + id);

        }
    }
}
