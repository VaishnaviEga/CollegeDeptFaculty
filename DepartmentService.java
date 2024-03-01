package com.example.ClgDeptFaculty.Service;

import com.example.ClgDeptFaculty.Model.Faculty;
import com.example.ClgDeptFaculty.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public void assignFaculties(int id, List<Faculty> faculties) {

    }

    public void assignHod(int id, Faculty hod) {
    }
    public List<Faculty> getFacultiesByDepartmentName(String deptname) {
        return repo.getFacultiesByDepartmentName(deptname);
    }
    public String getHodNameOfDepartment(String departmentName) {
        return repo.hodNameOfDepartment(departmentName);
    }
}
