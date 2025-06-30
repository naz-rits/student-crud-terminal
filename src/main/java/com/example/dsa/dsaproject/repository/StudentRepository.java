package com.example.dsa.dsaproject.repository;

import com.example.dsa.dsaproject.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

}
