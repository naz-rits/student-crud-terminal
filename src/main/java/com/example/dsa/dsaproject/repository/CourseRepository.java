package com.example.dsa.dsaproject.repository;

import com.example.dsa.dsaproject.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByStudent_StudentNumber(Long studentNumber);
}
