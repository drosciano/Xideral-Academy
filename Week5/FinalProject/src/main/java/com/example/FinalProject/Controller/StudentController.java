package com.example.FinalProject.controller;

import com.example.FinalProject.entity.Student;
import com.example.FinalProject.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tkd")
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student) {
        student.setId(0);
        studentRepository.save(student);
        return student;
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        Student temp = studentRepository.save(student);
        return temp;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student temp = studentRepository.findById(id).get();
        studentRepository.delete(temp);
        return id + " Record Deleted";
    }

    @DeleteMapping("/allStudents")
    public String deleteAllStudent() {
        studentRepository.deleteAll();
        return "All Records Deleted";
    }

    @GetMapping("/students/{school_name}")
    public List<Student> getStudentBySchool(@PathVariable String school_name) {
        return studentRepository.findBySchool(school_name);
    }
}
