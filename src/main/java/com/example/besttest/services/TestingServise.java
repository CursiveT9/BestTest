package com.example.besttest.services;

import com.example.besttest.dtos.TestingDTO;
import jakarta.transaction.Transactional;
import java.util.List;

public interface TestingServise {
    TestingDTO createTesting(TestingDTO testingDTO);
    List<TestingDTO> getAllTestings();
    void deleteTesting(String testingId);
    TestingDTO getTestingDTOById(String id);
    @Transactional
    TestingDTO editTesting(String id, TestingDTO testingDTO);
}
