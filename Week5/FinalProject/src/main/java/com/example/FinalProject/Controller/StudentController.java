package com.example.FinalProject.Controller;

import com.example.FinalProject.Config.StudentProcessor;
import com.example.FinalProject.Entity.Student;
import com.example.FinalProject.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TKD")
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/student/{teacher_id}")
    public List<Student> getStudentByTeacher(@PathVariable int teacher_id) {
        return studentRepository.findByTeacher(teacher_id);
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student) {
        student.setId(0);
        studentRepository.save(student);
        return student;
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        if (studentRepository.findById(id).isPresent())
            studentRepository.delete(studentRepository.findById(id).get());
        else
            return id + " Student has not been found";
        return id + " Student has been Deleted Correctly";
    }
}
