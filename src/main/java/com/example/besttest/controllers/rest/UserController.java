package com.example.besttest.controllers.rest;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.enums.UserRoleType;
import com.example.besttest.services.UserService;
import com.example.besttestapi.controllers.UserApi;
import com.example.besttestapi.dtos.ActionApi;
import com.example.besttestapi.dtos.UserDTOApi;
import com.example.besttestapi.enums.UserRoleTypeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/users")
public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public ResponseEntity<UserDTOApi> createUser(@RequestBody UserDTOApi userDTOApi) {
        UserDTO userDTO = new UserDTO(userDTOApi.getUsername(), userDTOApi.getPassword(), userDTOApi.getFirstName(), userDTOApi.getLastName(), userDTOApi.getIsActive(), userDTOApi.getImageUrl(), UserRoleType.valueOf(userDTOApi.getRole().name()), userDTOApi.getEmail(), userDTOApi.getPoints());
        UserDTO createdUser = userService.createUser(userDTO);
        userDTOApi = new UserDTOApi(createdUser.getId(), createdUser.getUsername(), createdUser.getPassword(), createdUser.getFirstName(), createdUser.getLastName(), createdUser.getIsActive(), createdUser.getImageUrl(), UserRoleTypeApi.valueOf(createdUser.getRole().name()), createdUser.getEmail(), createdUser.getPoints());
        userDTOApi = createLinks(userDTOApi);
        return ResponseEntity.ok(userDTOApi);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDTOApi> getUserById (@PathVariable String id) {
        UserDTO userDTO = userService.getUserDTOById(id);
        if (userDTO == null) {
            return ResponseEntity.notFound().build();
        }
        UserDTOApi userDTOApi = new UserDTOApi(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getIsActive(), userDTO.getImageUrl(), UserRoleTypeApi.valueOf(userDTO.getRole().name()), userDTO.getEmail(), userDTO.getPoints());
        userDTOApi = createLinks(userDTOApi);
        return ResponseEntity.ok(userDTOApi);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserDTOApi>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        if (List.of(users).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<UserDTOApi> userDTOApis = users.stream()
                .map(user -> {
                    UserDTOApi userDTOApi = new UserDTOApi(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getIsActive(), user.getImageUrl(), UserRoleTypeApi.valueOf(user.getRole().name()), user.getEmail(), user.getPoints());
                    userDTOApi = createLinks(userDTOApi);
                    return userDTOApi;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOApis);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDTOApi> updateUser(@PathVariable String id, @RequestBody UserDTOApi userDTOApi) {
        UserDTO userDTO = new UserDTO(userDTOApi.getUsername(), userDTOApi.getPassword(), userDTOApi.getFirstName(), userDTOApi.getLastName(), userDTOApi.getIsActive(), userDTOApi.getImageUrl(), UserRoleType.valueOf(userDTOApi.getRole().name()), userDTOApi.getEmail(), userDTOApi.getPoints());
        UserDTO updatedUser = userService.editUser(id, userDTO);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        userDTOApi = new UserDTOApi(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getPassword(), updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getIsActive(), updatedUser.getImageUrl(), UserRoleTypeApi.valueOf(updatedUser.getRole().name()), updatedUser.getEmail(), updatedUser.getPoints());
        userDTOApi = createLinks(userDTOApi);
        return ResponseEntity.ok(userDTOApi);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    public UserDTOApi createLinks(UserDTOApi userDTO) {
        Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUserById(userDTO.getId())).withSelfRel();
        Link allUsersLink = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withRel("allUsers");

        userDTO.add(selfLink);
        userDTO.add(allUsersLink);

        String updateHref = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).updateUser(userDTO.getId(), userDTO)).toUri().toString();
        String deleteHref = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).deleteUser(userDTO.getId())).toUri().toString();
        String createHref = linkTo(WebMvcLinkBuilder.methodOn(UserController.class).createUser(userDTO)).toUri().toString();

        userDTO.addAction("update", new ActionApi(updateHref, "PUT", "application/json"));
        userDTO.addAction("delete", new ActionApi(deleteHref, "DELETE"));
        userDTO.addAction("create", new ActionApi(createHref, "POST", "application/json"));

        return userDTO;
    }
}
