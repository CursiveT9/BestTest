package com.example.besttest.repositories;

import com.example.besttest.models.entities.Testing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestingRepository extends JpaRepository<Testing, String> {
    List<Testing> findByUserUsername (String username);
}
