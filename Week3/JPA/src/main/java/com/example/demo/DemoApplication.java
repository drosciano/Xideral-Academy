package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {

		return runner -> {

			createEmployee(employeeDAO);

			createMultipleEmployees(employeeDAO);

			readEmployee(employeeDAO);

			queryForEmployees(employeeDAO);

			queryForEmployeeByLastName(employeeDAO);

			updateEmployee(employeeDAO);

			deleteEmployee(employeeDAO);

			deleteAllEmployees(employeeDAO);
		};
	}

	private void createEmployee(EmployeeDAO employeeDAO) {
		System.out.println("Creating new employee object ...");
		Employee temp = new Employee("Pedro", "Hernandez", "phernandez@code.com", 25000.00, "IT");

		System.out.println("Saving the employee ...");
		employeeDAO.save(temp);

		System.out.println("Saved employee. Generated id: " + temp.getId());
	}

	private void createMultipleEmployees(EmployeeDAO employeeDAO) {

		System.out.println("Creating 3 employee objects ...");
		Employee temp1 = new Employee("John", "Doe", "john@luv2code.com", 20000, "HR");
		Employee temp2 = new Employee("Mary", "Public", "mary@luv2code.com", 25000, "Finance");
		Employee temp3 = new Employee("Bonita", "Applebum", "bonita@luv2code.com", 22500, "HR");

		System.out.println("Saving the employees ...");
		employeeDAO.save(temp1);
		employeeDAO.save(temp2);
		employeeDAO.save(temp3);
	}
	private void readEmployee(EmployeeDAO employeeDAO) {

		System.out.println("Creating new employee object ...");
		Employee temp = new Employee("Epeneto", "Duck", "daffy@luv2code.com", 20000, "IT");

		System.out.println("Saving the employee ...");
		employeeDAO.save(temp);

		int theId = temp.getId();
		System.out.println("Saved employee. Generated id: " + theId);

		System.out.println("Retrieving employee with id: " + theId);
		Employee employee = employeeDAO.findById(theId);

		System.out.println("Found the employee: " + employee);
	}

	private void queryForEmployees(EmployeeDAO employeeDAO) {

		List<Employee> employees = employeeDAO.findAll();

		for (Employee temp : employees) {
			System.out.println(temp);
		}
	}

	private void queryForEmployeeByLastName(EmployeeDAO employeeDAO) {

		List<Employee> employees = employeeDAO.findByLastName("Doe");

		for (Employee temp : employees) {
			System.out.println(temp);
		}
	}

	private void updateEmployee(EmployeeDAO employeeDAO) {

		int id = 73;
		System.out.println("Getting employee by last name: Doe");
		Employee employee = employeeDAO.findById(id);

		System.out.println("Updating employee ...");
		employee.setFirst_name("John");

		employeeDAO.update(employee);

		System.out.println("Updated employee: " + employee);
	}

	private void deleteAllEmployees(EmployeeDAO employeeDAO) {

		System.out.println("Deleting all employees");
		int numRowsDeleted = employeeDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteEmployee(EmployeeDAO employeeDAO) {

		int id = 75;
		System.out.println("Deleting employee id: " + id);
		employeeDAO.delete(id);
	}
}
