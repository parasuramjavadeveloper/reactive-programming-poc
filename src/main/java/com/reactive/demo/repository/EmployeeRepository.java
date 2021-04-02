package com.reactive.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.demo.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {

}
