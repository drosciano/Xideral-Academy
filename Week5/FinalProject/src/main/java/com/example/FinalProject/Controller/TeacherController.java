package com.example.FinalProject.Controller;

import com.example.FinalProject.Entity.School;
import com.example.FinalProject.Repository.TeacherRepository;
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
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<School> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teacher/{id}")
    public Optional<School> getTeacher(@PathVariable int id) {
        return teacherRepository.findById(id);
    }

    @PostMapping("/teacher")
    public School postTeacher(@RequestBody School school) {
        school.setId(0);
        teacherRepository.save(school);
        return school;
    }

    @PutMapping("/teacher")
    public School updateTeacher(@RequestBody School school) {
        return teacherRepository.save(school);
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable int id) {
        if (teacherRepository.findById(id).isPresent())
            teacherRepository.delete(teacherRepository.findById(id).get());
        else
            return id + " Teacher has not been found";
        return id + " Teacher has been Deleted Correctly";
    }

}
