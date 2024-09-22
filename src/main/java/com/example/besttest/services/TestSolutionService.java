package com.example.besttest.services;

import com.example.besttest.dtos.TestSolutionDTO;
import jakarta.transaction.Transactional;
import java.util.List;

public interface TestSolutionService {
    TestSolutionDTO createTestSolution(TestSolutionDTO testSolutionDTO);
    List<TestSolutionDTO> getAllTestSolutions();
    void deleteTestSolution(String testSolutionId);
    TestSolutionDTO getTestSolutionDTOById(String id);
    @Transactional
    TestSolutionDTO editTestSolution(String id, TestSolutionDTO testSolutionDTO);
}
