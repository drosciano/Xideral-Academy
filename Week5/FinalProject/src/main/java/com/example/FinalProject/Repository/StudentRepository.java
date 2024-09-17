package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.school_name = ?1")
    List<Student> findBySchool(String school_name);
}
