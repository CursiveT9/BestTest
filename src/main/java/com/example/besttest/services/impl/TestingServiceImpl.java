package com.example.besttest.services.impl;

import com.example.besttest.dtos.TestingDTO;
import com.example.besttest.models.entities.Testing;
import com.example.besttest.models.entities.User;
import com.example.besttest.repositories.TestingRepository;
import com.example.besttest.repositories.UserRepository;
import com.example.besttest.services.TestingServise;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestingServiceImpl implements TestingServise {

    private final TestingRepository testingRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public TestingServiceImpl(TestingRepository testingRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.testingRepository = testingRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public TestingDTO createTesting(TestingDTO testingDTO) {
        User user = userRepository.findById(testingDTO.getCreatorId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Testing testing = new Testing();
        testing.setTitle(testingDTO.getTitle());
        testing.setDescription(testingDTO.getDescription());
        testing.setCreator(user);
        testing.setContent(testingDTO.getTestContentUrl());
        testing.setAccessLevel(testingDTO.getAccessLevel());
        testing.setPoints(testingDTO.getPoints());
        TestingDTO savedTesting = modelMapper.map(testingRepository.save(testing), TestingDTO.class);
        return modelMapper.map(savedTesting, TestingDTO.class);
    }

    @Override
    public List<TestingDTO> getAllTestings() {
        List<Testing> testings = testingRepository.findAll();
        return testings.stream()
                .map(testing -> modelMapper.map(testing, TestingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTesting(String testingId) {
        testingRepository.deleteById(testingId);
    }

    @Override
    public TestingDTO getTestingDTOById(String id) {
        Optional<Testing> testing = testingRepository.findById(id);
        return modelMapper.map(testing, TestingDTO.class);
    }

    @Override
    public TestingDTO editTesting(String id, TestingDTO testingDTO) {
        return null;
    }

    @Override
    public List<TestingDTO> getTestingsByUserUsername(String username) {
        List<Testing> testings = testingRepository.findByUserUsername(username);
        return testings.stream()
                .map(testing -> modelMapper.map(testing, TestingDTO.class))
                .collect(Collectors.toList());
    }
}
