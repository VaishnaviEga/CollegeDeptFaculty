package com.example.ClgDeptFaculty.Controller;

import com.example.ClgDeptFaculty.Model.Faculty;
import com.example.ClgDeptFaculty.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @PostMapping("/addfaculties")
    public void assignFaculties(@PathVariable int departmentId, @RequestBody List<Faculty> faculties) {
        service.assignFaculties(departmentId, faculties);
    }

    @PostMapping("/assign hod")
    public void assignHod(@PathVariable int departmentId, @RequestBody Faculty hod) {
        service.assignHod(departmentId, hod);
    }

    @GetMapping("/List of faculties")
    public List<Faculty> getFacultiesByDepartmentName(@RequestParam String departmentName) {
        return service.getFacultiesByDepartmentName(departmentName);
    }

    @GetMapping("/ get hod name")
    public String getHodNameOfDepartment(@RequestParam String departmentName) {
        return service.getHodNameOfDepartment(departmentName);
    }
}
