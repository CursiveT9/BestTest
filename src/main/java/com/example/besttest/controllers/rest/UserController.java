package com.example.besttest.controllers.rest;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.besttest.dtos.Action;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        createdUser = createLinks(createdUser);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable String id) {
        UserDTO userDTO = userService.getUserDTOById(id);
        userDTO = createLinks(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return users.stream()
                .peek(user -> {
                    user = createLinks(user);
                })
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.editUser(id, userDTO);
        updatedUser = createLinks(updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // Возвращаем статус 204 No Content
    }

    public UserDTO createLinks(UserDTO userDTO) {
        Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUserById(userDTO.getId())).withSelfRel();
        Link allUsersLink = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withRel("allUsers");

        userDTO.add(selfLink);
        userDTO.add(allUsersLink);

        String updateHref = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).updateUser(userDTO.getId(), null)).toUri().toString();
        String deleteHref = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).deleteUser(userDTO.getId())).toUri().toString();
        String createHref = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).createUser(userDTO)).toUri().toString();

        userDTO.addAction("update", new Action(updateHref, "PUT", "application/json"));
        userDTO.addAction("delete", new Action(deleteHref, "DELETE"));
        userDTO.addAction("create", new Action(createHref, "POST", "application/json"));

        return userDTO;
    }
}
