package com.reactive.demo.resource;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.model.Employee;
import com.reactive.demo.model.EmployeeEvent;
import com.reactive.demo.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeResource {

	private EmployeeRepository employeeRepository;

	public EmployeeResource(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping
	public Flux<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Employee> getId(@PathVariable("id") final String empId) {
		return employeeRepository.findById(empId);
	}
	
	@PutMapping
	public Mono<Employee> update(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@GetMapping(value="/{id}/events",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String empId) {
		return employeeRepository.findById(empId).flatMapMany(employee -> {
			// artificial duration
			
			// Flux interval which returns data every 2 sec
			Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));

			Flux<EmployeeEvent> employeeEventFlux = Flux
					.fromStream(Stream.generate(() -> new EmployeeEvent(employee, new Date())));
			return Flux.zip(interval, employeeEventFlux).map(Tuple2::getT2);
		});
	}

}
