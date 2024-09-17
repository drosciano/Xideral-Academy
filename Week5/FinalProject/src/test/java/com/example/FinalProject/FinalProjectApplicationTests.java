package com.example.FinalProject;

import com.example.FinalProject.controller.StudentController;
import com.example.FinalProject.entity.Message;
import com.example.FinalProject.entity.Student;
import com.example.FinalProject.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class FinalProjectApplicationTests {
	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentController studentController;

	@Test
	void getStudent() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime birth_date = LocalDateTime.parse("2023-08-27 17:48:34",formatter);
		LocalDateTime start_date = LocalDateTime.parse("2000-02-27 02:11:53",formatter);
		Student result = new Student(1,"Tin","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");
		Mockito.when(studentController.getStudent(result.getId())).thenReturn(Optional.of(result));
		final Student temp = studentController.getStudent(result.getId()).get();
		Assertions.assertEquals(result, temp);
		Mockito.verify(studentRepository).findById(result.getId());
	}

	@Test
	void getStudents() {
		Message message = new Message();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime birth_date = LocalDateTime.parse("2023-08-27 17:48:34",formatter);
		LocalDateTime start_date = LocalDateTime.parse("2000-02-27 02:11:53",formatter);
		Student s1 = new Student(1,"Tin","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");
		birth_date =  LocalDateTime.parse("2006-02-27 09:43:26", formatter);
		start_date =  LocalDateTime.parse("2019-01-04 11:51:36", formatter);
		Student s2 =  new Student(2,"Overhold","Darius Philbrick","Darius","Gerhartz","Philbrick",birth_date,start_date,"Software Engineer II","4 kup");
		List<Student> result = Arrays.stream(new Student[]{s1, s2}).toList();;
		Mockito.when(studentController.getStudents()).thenReturn(result);
		final List<Student> temp = studentController.getStudents();
		Assertions.assertEquals(result, temp);
		Mockito.verify(studentRepository).findAll();
	}

	@Test
	void getStudentsBySchool() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime birth_date = LocalDateTime.parse("2023-08-27 17:48:34",formatter);
		LocalDateTime start_date = LocalDateTime.parse("2000-02-27 02:11:53",formatter);
		Student s1 = new Student(1,"Tin","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");
		birth_date =  LocalDateTime.parse("2006-02-27 09:43:26", formatter);
		start_date =  LocalDateTime.parse("2019-01-04 11:51:36", formatter);
		Student s2 =  new Student(2,"Tin","Darius Philbrick","Darius","Gerhartz","Philbrick",birth_date,start_date,"Software Engineer II","4 kup");
		List<Student> result = Arrays.stream(new Student[]{s1, s2}).toList();;
		Mockito.when(studentController.getStudentBySchool("Tin")).thenReturn(result);
		final List<Student> temp = studentController.getStudentBySchool("Tin");
		Assertions.assertEquals(result, temp);
		Mockito.verify(studentRepository).findBySchool("Tin");
	}

	@Test
	void postStudent() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime birth_date = LocalDateTime.parse("2023-08-27 17:48:34",formatter);
		LocalDateTime start_date = LocalDateTime.parse("2000-02-27 02:11:53",formatter);
		Student result = new Student(1,"Tin","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");

		Mockito.when(studentController.postStudent(result)).thenReturn(result);

		final Student temp = studentController.postStudent(result);

		Assertions.assertEquals(result.getId(), temp.getId());
		Assertions.assertEquals(result.getSchool_name(), temp.getSchool_name());
		Assertions.assertEquals(result.getTeacher(), temp.getTeacher());
		Assertions.assertEquals(result.getFirst_name(), temp.getFirst_name());
		Assertions.assertEquals(result.getLast_name(), temp.getLast_name());
		Assertions.assertEquals(result.getLast_name_2(), temp.getLast_name_2());
		Assertions.assertEquals(result.getBirth_date(), temp.getBirth_date());
		Assertions.assertEquals(result.getStart_date(), temp.getStart_date());
		Assertions.assertEquals(result.getOccupation(), temp.getOccupation());
		Assertions.assertEquals(result.getBelt(), temp.getBelt());

		Mockito.verify(studentRepository).save(result);
	}

	@Test
	void updateStudent() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime birth_date = LocalDateTime.parse("2023-08-27 17:48:34",formatter);
		LocalDateTime start_date = LocalDateTime.parse("2000-02-27 02:11:53",formatter);
		Student s1 = new Student(1,"Tin","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");
		Student s2 = new Student(1,"Nit","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");

		Mockito.when(studentController.updateStudent(s2)).thenReturn(s2);

		final Student temp = studentController.updateStudent(s2);
		Assertions.assertEquals(s2, temp);

		Mockito.verify(studentRepository).save(s2);
	}

	@Test
	void deleteStudent() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime birth_date = LocalDateTime.parse("2023-08-27 17:48:34",formatter);
		LocalDateTime start_date = LocalDateTime.parse("2000-02-27 02:11:53",formatter);
		Student result = new Student(1,"Tin","Heywood Lorriman","Heywood","Downie","Lorriman",birth_date,start_date,"Dental Hygienist","3 dan");

		Mockito.when(studentRepository.findById(result.getId()))
				.thenReturn(Optional.of(result));
		Mockito.doNothing().when(studentRepository).delete(result);
		final String temp = studentController.deleteStudent(result.getId());

		Assertions.assertEquals(result.getId() + " Record Deleted", temp);

		Mockito.verify(studentRepository).delete(result);
	}

	@Test
	void deleteAllStudent() {
		Mockito.doNothing().when(studentRepository).deleteAll();
		final String temp = studentController.deleteAllStudent();

		Assertions.assertEquals("All Records Deleted", temp);

		Mockito.verify(studentRepository).deleteAll();
	}
}
