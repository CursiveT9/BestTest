package com.example.besttest.repositories;

import com.example.besttest.models.entities.TestSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSolutionRepository extends JpaRepository<TestSolution, String> {
}
