package com.example.demo;

import com.example.demo.controller.Controller;
import com.example.demo.models.Employee;
import com.example.demo.repository.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SpringJpaCrudApplicationTests {
	@Mock
	private Repository repository;

	@InjectMocks
	private Controller employeeController;

//	@BeforeEach
//	public void setUp() {
//		employeeController = new Controller(repository);
//	}

	@Test
	public void postEmployee() {
		Employee result = new Employee(0, "Duilio", "Rosciano", "drosciano@mail.com", "IT");
		Mockito.when(employeeController.postEmployee(result))
				.thenReturn(result);

		final Employee temp = employeeController.postEmployee(result);

		Assertions.assertEquals(result.getDepartment(), temp.getDepartment());
		Assertions.assertEquals(result.getEmail(), temp.getEmail());
		Assertions.assertEquals(result.getLast_name(), temp.getLast_name());
		Assertions.assertEquals(result.getFirst_name(), temp.getFirst_name());
		Assertions.assertEquals(result.getId(), temp.getId());

		Mockito.verify(repository).save(result);
	}

	@Test
	public void getEmployee() {
		Employee result = new Employee(1, "Duilio", "Rosciano", "drosciano@mail.com", "IT");
		Mockito.when(employeeController.getEmployee(result.getId())).thenReturn(Optional.of(result));
		final Employee temp = employeeController.getEmployee(result.getId()).get();
		Assertions.assertEquals(result, temp);
		Mockito.verify(repository).findById(result.getId());
	}

	@Test
	public void getEmployees() {
		Employee e1 = new Employee(1, "Duilio", "Rosciano", "drosciano@mail.com", "IT");
		Employee e2 = new Employee(2, "Luis", "Montoua", "lmontoya@mail.com", "Design");
		List<Employee> result = Arrays.stream(new Employee[]{e1, e2}).toList();
		Mockito.when(employeeController.getEmployees()).thenReturn(result);
		List<Employee> temp = employeeController.getEmployees();
		Assertions.assertEquals(result, temp);
		Mockito.verify(repository).findAll();
	}

	@Test
	public void updateEmployee() {
		Employee e1 = new Employee(1, "Duilio", "Rosciano", "drosciano@mail.com", "IT");
		Employee e2 = new Employee(1, "Duilio", "Rosciano", "drosciano@mail.com", "HR");

		Mockito.when(employeeController.updateEmployee(e2)).thenReturn(e2);

		final Employee temp = employeeController.updateEmployee(e2);

		Assertions.assertEquals(e2, temp);

		Mockito.verify(repository).save(e2);
	}

	@Test
	public void deleteEmployee() {
		Employee result = new Employee(1, "Duilio", "Rosciano", "drosciano@mail.com", "IT");

		Mockito.when(repository.findById(result.getId()))
				.thenReturn(Optional.of(result));
		Mockito.doNothing().when(repository).delete(result);
		final String temp = employeeController.deleteEmployee(result.getId());

		Assertions.assertEquals(result.getId() + " Record Deleted", temp);

		Mockito.verify(repository).delete(result);
	}

}
