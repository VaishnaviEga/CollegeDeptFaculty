package com.example.ClgDeptFaculty.Repository;

import com.example.ClgDeptFaculty.Model.Department;
import com.example.ClgDeptFaculty.Model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Faculty> getFacultiesByDepartmentName(String deptname);


    String hodNameOfDepartment(String departmentName);
}
