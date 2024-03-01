package com.example.ClgDeptFaculty.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name="Department")
public class Department {
    @Id
    @GeneratedValue
    public int id;
    public String departmentName;
    private  String hodNameOfDepartment;
    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonIgnore
    private College college;
    public Department() {
    }

    public Department(String departmentName, String hodNameOfDepartment) {
        this.departmentName =departmentName;
        this.hodNameOfDepartment = hodNameOfDepartment;
    }

    // Getters and setters for other properties

    public String getHodNameOfDepartment() {
        return hodNameOfDepartment;
    }

    public void setHodNameOfDepartment(String hodNameOfDepartment) {
        this.hodNameOfDepartment= hodNameOfDepartment;
    }
}
