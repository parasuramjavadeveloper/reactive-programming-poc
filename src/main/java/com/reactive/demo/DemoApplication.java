package com.reactive.demo;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reactive.demo.model.Employee;
import com.reactive.demo.repository.EmployeeRepository;

@SpringBootApplication
public class DemoApplication {

	@Bean
	CommandLineRunner employees(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.deleteAll().subscribe(null, null, () -> {
				Stream.of(new Employee(UUID.randomUUID().toString(), "peter", 23000L),
						new Employee(UUID.randomUUID().toString(), "sam", 13000L),
						new Employee(UUID.randomUUID().toString(), "ram", 20000L),
						new Employee(UUID.randomUUID().toString(), "chris", 53000L)).forEach(employee -> {
							employeeRepository.save(employee).subscribe(System.out::println);
						});

			});

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
