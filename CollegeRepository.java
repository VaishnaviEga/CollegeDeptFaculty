package com.example.ClgDeptFaculty.Repository;

import com.example.ClgDeptFaculty.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepository extends JpaRepository<College,Integer> {
    Optional<College> findByName(String name);

}
