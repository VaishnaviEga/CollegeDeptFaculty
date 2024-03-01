package com.example.ClgDeptFaculty.Controller;


import com.example.ClgDeptFaculty.Model.College;
import com.example.ClgDeptFaculty.Model.Department;
import com.example.ClgDeptFaculty.Model.Faculty;
import com.example.ClgDeptFaculty.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService service;
    @PostMapping("/addcollege")
    public College addCollege(@RequestBody College college) {
        return service.addCollege(college);
    }
    @GetMapping("/allcolleges")
    public List<College> getAllColleges() {
        return service.getAllColleges();
    }
    @GetMapping("/college by id/{id}")
    public College getCollegeById(@PathVariable int id) {
        return service.getCollegeById(id);
    }
    @GetMapping("/college by name/{name}")
    public College getCollegeByName(@PathVariable String name) {
        return service.getCollegeByName(name);
    }
    @PutMapping("/updatecollege/{name}")
    public College updateCollegeByName(@PathVariable String name, @RequestBody College college) {
        return service.updateCollegeByName(name, college);
    }
    @DeleteMapping("/deletecollege/{name}")
    public void deleteCollegeById(@PathVariable int id) {
        service.deleteCollegeById(id);
    }
    @PostMapping("/add departments")
    public College addDepartmentToCollege(@PathVariable int collegeId, @RequestBody Department department) {
        return service.addDepartmentToCollege(collegeId, department);
    }
    @GetMapping("/list of departments")
    public List<Department> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        return service.getDepartmentsByCollegeName(collegeName);
    }
    @PostMapping("/add faculties")
    public void addFacultiesInCollege(@PathVariable int collegeId, @RequestBody List<Faculty> faculties) {
        service.addFaculties(collegeId, faculties);
    }
    @GetMapping("/list of faculties/{collegeId}")
    public List<Faculty> getFacultiesInCollege(@PathVariable int collegeId) {
        return service.getFacultiesInCollege(collegeId);
    }



}
