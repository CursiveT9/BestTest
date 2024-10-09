package com.example.besttest.datafetchers;

import com.example.besttest.dtos.TestingDTO;
import com.example.besttest.services.TestingServise;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@DgsComponent
public class TestingDataFetcher {

    private TestingServise testingServise;

    @Autowired
    public void setTestingServise(TestingServise testingServise) {
        this.testingServise = testingServise;
    }

    @DgsQuery
    public List<TestingDTO> testingsByUserUsername(@InputArgument String username) {
        return testingServise.getTestingsByUserUsername(username);
    }
}