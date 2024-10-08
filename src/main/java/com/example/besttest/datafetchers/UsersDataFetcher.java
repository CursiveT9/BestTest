package com.example.besttest.datafetchers;

import com.example.besttest.models.entities.User;
import com.example.besttest.repositories.UserRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class UsersDataFetcher {
    @Autowired
    private UserRepository userRepository;

    @DgsQuery
    public List<User> users(@InputArgument String username) {
        if (username == null) {
            return userRepository.findAll();
        }
        Optional<User> one = userRepository.findByUsername(username);
        return one.map(List::of).orElseGet(List::of);
    }
}