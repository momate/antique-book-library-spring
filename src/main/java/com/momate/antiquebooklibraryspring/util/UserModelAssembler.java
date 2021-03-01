package com.momate.antiquebooklibraryspring.util;

import com.momate.antiquebooklibraryspring.controller.BookController;
import com.momate.antiquebooklibraryspring.controller.UserController;
import com.momate.antiquebooklibraryspring.dto.UserDTO;
import com.momate.antiquebooklibraryspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class UserModelAssembler implements RepresentationModelAssembler<User, UserDTO> {

    @Autowired
    private ModelConverter modelConverter;

    @Override
    public UserDTO toModel(User entity) {
        UserDTO userDTO = modelConverter.userEntityToUserDto(entity);

        Link selfLink = linkTo(methodOn(UserController.class).getUserById(entity.getId())).withSelfRel();
        userDTO.add(selfLink);

        return userDTO;
    }

    @Override
    public CollectionModel<UserDTO> toCollectionModel(Iterable<? extends User> entities) {
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : entities){
            UserDTO userDto = modelConverter.userEntityToUserDto(user);
            userDto.add(linkTo(methodOn(UserController.class)
                    .getUserById(userDto.getId())).withSelfRel());
            userDTOS.add(userDto);
        }

        return new CollectionModel<>(userDTOS);
    }
}
