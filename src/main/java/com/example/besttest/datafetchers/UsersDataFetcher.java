package com.example.besttest.datafetchers;

import com.example.besttest.dtos.UserDTO;
import com.example.besttest.services.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class UsersDataFetcher {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @DgsQuery
    public List<UserDTO> users(@InputArgument String username) {
        if (username == null) {
            return userService.getAllUsers();
        }
        UserDTO one = userService.getUserByUsername(username);
        return List.of(one);
    }

    @DgsMutation
    public UserDTO createUser(@InputArgument String username, @InputArgument String password, @InputArgument String firstName,
                              @InputArgument String lastName, @InputArgument Boolean isActive,
                              @InputArgument String imageUrl, @InputArgument String email, @InputArgument int points) {
        UserDTO userDTO = new UserDTO(username, password, firstName, lastName, isActive, imageUrl, email, points);
        return userService.createUser(userDTO);
    }

    @DgsMutation
    public UserDTO updateUser(@InputArgument String id, @InputArgument String username, @InputArgument String password,
                              @InputArgument String firstName, @InputArgument String lastName, @InputArgument Boolean isActive,
                              @InputArgument String imageUrl, @InputArgument String email, @InputArgument int points) {
        UserDTO userDTO = new UserDTO(username, password, firstName, lastName, isActive, imageUrl, email, points);
        return userService.editUser(id, userDTO);
    }

    @DgsMutation
    public String deleteUser(@InputArgument String id) {
        userService.deleteUser(id);
        return "sas: " + id;
    }

}