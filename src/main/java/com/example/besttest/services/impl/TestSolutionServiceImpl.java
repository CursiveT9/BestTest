package com.example.besttest.services.impl;

import com.example.besttest.dtos.TestSolutionDTO;
import com.example.besttest.models.entities.TestSolution;
import com.example.besttest.repositories.TestSolutionRepository;
import com.example.besttest.services.TestSolutionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestSolutionServiceImpl implements TestSolutionService {

    private final TestSolutionRepository testSolutionRepository;
    private final ModelMapper modelMapper;

    public TestSolutionServiceImpl(TestSolutionRepository testSolutionRepository, ModelMapper modelMapper) {
        this.testSolutionRepository = testSolutionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestSolutionDTO createTestSolution(TestSolutionDTO testSolutionDTO) {
        return null;
    }

    @Override
    public List<TestSolutionDTO> getAllTestSolutions() {
        List<TestSolution> testSolutions = testSolutionRepository.findAll();
        return testSolutions.stream()
                .map(testSolution -> modelMapper.map(testSolution, TestSolutionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTestSolution(String testSolutionId) {
        testSolutionRepository.deleteById(testSolutionId);
    }

    @Override
    public TestSolutionDTO getTestSolutionDTOById(String id) {
        Optional<TestSolution> testSolution = testSolutionRepository.findById(id);
        return modelMapper.map(testSolution, TestSolutionDTO.class);
    }

    @Override
    public TestSolutionDTO editTestSolution(String id, TestSolutionDTO testSolutionDTO) {
        return null;
    }
}
