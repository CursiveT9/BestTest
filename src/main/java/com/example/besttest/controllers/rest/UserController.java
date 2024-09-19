package com.example.besttest.controllers.rest;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // Метод для создания пользователя с ссылкой на самого себя
    @PostMapping
    public EntityModel<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);

        // Создаем ссылку на только что созданного пользователя
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUserById(createdUser.getId())).withSelfRel();

        return EntityModel.of(createdUser, selfLink);
    }

    // Метод для получения пользователя по ID
    @GetMapping("/{id}")
    public EntityModel<UserDTO> getUserById(@PathVariable String id) {
        UserDTO userDTO = userService.getUserDTOById(id);

        // Создаем ссылку на самого себя
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUserById(id)).withSelfRel();

        // Добавляем дополнительные ссылки на другие методы
        Link allUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withRel("allUsers");

        return EntityModel.of(userDTO, selfLink, allUsersLink);
    }

    // Метод для получения всех пользователей
    @GetMapping
    public List<EntityModel<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();

        return users.stream()
                .map(user -> {
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUserById(user.getId())).withSelfRel();
                    return EntityModel.of(user, selfLink);
                })
                .collect(Collectors.toList());
    }

    // Метод для обновления пользователя
    @PutMapping("/{id}")
    public EntityModel<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.editUser(id, userDTO);

        // Создаем ссылку на обновленного пользователя
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUserById(updatedUser.getId())).withSelfRel();

        return EntityModel.of(updatedUser, selfLink);
    }

    // Метод для удаления пользователя
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
