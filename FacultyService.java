package com.example.ClgDeptFaculty.Service;

import com.example.ClgDeptFaculty.Model.Faculty;
import com.example.ClgDeptFaculty.Repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository repo;

    public Faculty addFaculty(Faculty faculty) {
        return repo.save(faculty);
    }
    public Faculty getFacultiesByCollegeId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void addFaculties(int collegeId, List<Faculty> faculties) {
        repo.saveAll(faculties);
    }

    public List<Faculty> getFacultiesInCollege(int collegeId) {
            return repo.findByCollegeId(collegeId);
    }
    public String getHodNameOfDepartment(String departmentName) {
        return repo.findByName(departmentName);

    }
}
