package com.example.besttest.controllers.rest;

import com.example.besttest.dtos.TestingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.besttest.services.TestingServise;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/testings")
public class TestingController {

    private TestingServise testingService;

    @Autowired
    public void setTestingService(TestingServise testingService) {
        this.testingService = testingService;
    }

    @GetMapping
    public List<TestingDTO> getAllTestings() {
        List<TestingDTO> testings = testingService.getAllTestings();
        return testings.stream()
                .peek(testing -> {
                    testing = createLinks(testing);
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{username}")
    public List<TestingDTO> getTestingsByUserUsername(@PathVariable String username) {
        List<TestingDTO> testings = testingService.getTestingsByUserUsername(username);
        return testings.stream()
                .peek(testing -> {
                    testing = createLinks(testing);
                })
                .collect(Collectors.toList());
    }

    private TestingDTO createLinks(TestingDTO testing) {
        Link selfLink = linkTo(TestingController.class).slash(testing.getId()).withSelfRel();
        Link userLink = linkTo(UserController.class).slash(testing.getCreatorId()).withRel("creator");
        testing.add(selfLink, userLink);
        return testing;
    }
}
