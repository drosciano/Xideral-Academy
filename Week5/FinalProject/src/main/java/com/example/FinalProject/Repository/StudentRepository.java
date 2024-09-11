package com.example.FinalProject.Repository;

import com.example.FinalProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> findByTeacher(int teacher_id);
}
