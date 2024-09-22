package com.example.besttest.services.impl;

import com.example.besttest.dtos.TestingDTO;
import com.example.besttest.models.entities.Testing;
import com.example.besttest.repositories.TestingRepository;
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

    public TestingServiceImpl(TestingRepository testingRepository, ModelMapper modelMapper) {
        this.testingRepository = testingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestingDTO createTesting(TestingDTO testingDTO) {
        return null;
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
}
