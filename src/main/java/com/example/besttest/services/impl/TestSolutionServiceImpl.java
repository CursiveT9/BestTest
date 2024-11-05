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
    private final UserServiceImpl userServiceImpl;

    public TestSolutionServiceImpl(TestSolutionRepository testSolutionRepository, ModelMapper modelMapper, UserServiceImpl userServiceImpl) {
        this.testSolutionRepository = testSolutionRepository;
        this.modelMapper = modelMapper;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public TestSolutionDTO createTestSolution(TestSolutionDTO testSolutionDTO) {
        TestSolution testSolution = modelMapper.map(testSolutionDTO, TestSolution.class);
        TestSolution savedTestSolution = testSolutionRepository.save(testSolution);
        sendTestCompletionMessage(savedTestSolution.getUser().getId(), savedTestSolution.getScore());
        return modelMapper.map(savedTestSolution, TestSolutionDTO.class);
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

    public void sendTestCompletionMessage(String userId, int score) {
        userServiceImpl.updateUserScore(userId, score);
    }
}
