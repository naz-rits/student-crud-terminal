package com.example.dsa.dsaproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_grade")
    private Integer courseGrade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "Course ID: " + id + "\nCourse Code: " + courseName
                + "\nCourse Grade: " + courseGrade;

    }

}
