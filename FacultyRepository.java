package com.example.ClgDeptFaculty.Repository;

import com.example.ClgDeptFaculty.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

    List<Faculty> findByCollegeId(int collegeId);

    String findByName(String departmentName);
}
