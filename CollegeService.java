package com.example.ClgDeptFaculty.Service;

import com.example.ClgDeptFaculty.Model.College;
import com.example.ClgDeptFaculty.Model.Department;
import com.example.ClgDeptFaculty.Model.Faculty;
import com.example.ClgDeptFaculty.Repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository repo;

    public College addCollege(College college) {
        return repo.save(college);
    }

    public List<College> getAllColleges() {
        return repo.findAll();
    }

    public College getCollegeById(int id) {
        return repo.findById(id).orElse(null);
    }

    public College getCollegeByName(String name) {
        return repo.findByName(name).orElse(null);
    }

    public College updateCollegeByName(String name, College updatedCollege) {
        Optional<College> optionalCollege = repo.findByName(name);
        if (optionalCollege.isPresent()) {
            College existingCollege = optionalCollege.get();
            existingCollege.setName(updatedCollege.getName());
            existingCollege.setId(existingCollege.getId());
            return repo.save(existingCollege);
        } else {
            throw new RuntimeException("College with name " + name + " not found");
        }
    }
    public void deleteCollegeById(int id) {
        repo.deleteById(id);
    }
    public College addDepartmentToCollege(int collegeId, Department department) {
        Optional<College> optionalCollege = repo.findById(collegeId);
        if (optionalCollege.isPresent()) {
            College college = optionalCollege.get();
            college.getDepartments().add(department);
            return repo.save(college);
        } else {
            throw new RuntimeException("College with id " + collegeId + " not found");
        }
    }
    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return repo.findByName(collegeName)
                .map(College::getDepartments)
                .orElseThrow(() -> new RuntimeException("College with name " + collegeName + " not found"));
    }


    public void addFaculties(int collegeId, List<Faculty> faculties) {
        Optional<College> optionalCollege = repo.findById(collegeId);
        if (optionalCollege.isPresent()) {
            College college = optionalCollege.get();
            college.setFaculties(faculties);
            repo.save(college);
        } else {
            throw new RuntimeException("College with id " + collegeId + " not found");
        }
    }

    public List<Faculty> getFacultiesInCollege(int collegeId) {
        Optional<College> optionalCollege = repo.findById(collegeId);
        if (optionalCollege.isPresent()) {
            College college = optionalCollege.get();
            return college.getFaculties();
        } else {
            throw new RuntimeException("College with id " + collegeId + " not found");
        }
    }
}
