package com.momate.antiquebooklibraryspring.service;

import com.momate.antiquebooklibraryspring.dao.UserRepository;
import com.momate.antiquebooklibraryspring.dto.UserDTO;
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
    public List<UserDTO> getAllUsers() {
        List<User> userEntitiesList = null;
        List<UserDTO> userDTOList = new ArrayList<>();

        userEntitiesList = userRepository.findAll();

        if(userEntitiesList != null){
            for (User u: userEntitiesList) {
                userDTOList.add(modelConverter.userEntityToUserDto(u));
            }
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserDTO userDTO = null;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userDTO = modelConverter.userEntityToUserDto(user.get());
        }

        return userDTO;
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
    public void deleteUser(UserDTO userDTO) {
        User user = null;
        if(userDTO != null){
            user = modelConverter.userDtoToEntity(userDTO);
            userRepository.delete(user);
        }
    }
}
