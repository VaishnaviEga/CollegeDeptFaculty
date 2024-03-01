package com.example.ClgDeptFaculty.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="college")
public class College {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Department> departments;
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Faculty> faculties;
}
