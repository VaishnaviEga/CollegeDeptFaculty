package com.example.ClgDeptFaculty.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Faculty")
public class Faculty {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonIgnore
    private College college;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
}
