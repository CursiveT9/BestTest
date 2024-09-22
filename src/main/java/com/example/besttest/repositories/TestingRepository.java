package com.example.besttest.repositories;

import com.example.besttest.models.entities.Testing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingRepository extends JpaRepository<Testing, String> {
}
