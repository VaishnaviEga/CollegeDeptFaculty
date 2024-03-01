package com.example.ClgDeptFaculty.Controller;

import com.example.ClgDeptFaculty.Model.Faculty;
import com.example.ClgDeptFaculty.Service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService service;

    @PostMapping("/add faculties")
    public void addFacultiesInCollege(@PathVariable int collegeId, @RequestBody List<Faculty> faculties) {
        service.addFaculties(collegeId, faculties);
    }

    @GetMapping("/list of faculties/{collegeId}")
    public List<Faculty> getFacultiesInCollege(@PathVariable int collegeId) {
        return service.getFacultiesInCollege(collegeId);
    }

}
