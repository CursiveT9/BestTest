package com.example.besttest.repositories;

import com.example.besttest.enums.UserRoleType;
import com.example.besttest.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    @Query("SELECT ur FROM UserRole ur WHERE ur.role = :roleType")
    Optional<UserRole> findByRole(@Param("roleType") UserRoleType roleType);

}
