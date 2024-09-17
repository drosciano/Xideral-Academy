package com.example.FinalProject.controller;

import com.example.FinalProject.config.MqConfig;
import com.example.FinalProject.entity.Message;
import com.example.FinalProject.entity.Student;
import com.example.FinalProject.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tkd")
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private RabbitTemplate template;

    @GetMapping("/students")
    public List<Student> getStudents() {
        Message message = new Message();
        message.setMessage("Request to get all students");
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        Message message = new Message();
        message.setMessage("Request to get a student with the id: " + id);
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        return studentRepository.findById(id);
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student) {
        Message message = new Message();
        message.setMessage("Request to post the student: " + student);
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        student.setId(0);
        studentRepository.save(student);
        return student;
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) {
        Message message = new Message();
        message.setMessage("Request to update the student: " + student.getId() + " with the information: " + student);
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        Student temp = studentRepository.save(student);
        return temp;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        Message message = new Message();
        message.setMessage("Request to delete the student with id: " + id);
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        Student temp = studentRepository.findById(id).get();
        studentRepository.delete(temp);
        return id + " Record Deleted";
    }

    @DeleteMapping("/allStudents")
    public String deleteAllStudent() {
        Message message = new Message();
        message.setMessage("Request to delete all students");
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        studentRepository.deleteAll();
        return "All Records Deleted";
    }

    @GetMapping("/students/{school_name}")
    public List<Student> getStudentBySchool(@PathVariable String school_name) {
        Message message = new Message();
        message.setMessage("Request to get all students from " + school_name + " school");
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MqConfig.EXCHANGE,
                MqConfig.ROUTING_KEY, message);
        return studentRepository.findBySchool(school_name);
    }
}
