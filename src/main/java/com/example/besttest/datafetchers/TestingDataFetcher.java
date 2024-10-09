package com.example.besttest.datafetchers;

import com.example.besttest.models.entities.Testing;
import com.example.besttest.repositories.TestingRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class TestingDataFetcher {
    @Autowired
    private TestingRepository testingRepository;

    @DgsQuery
    public List<Testing> testingsByUserUsername(@InputArgument String username) {
        return testingRepository.findByUserUsername(username);
    }
}