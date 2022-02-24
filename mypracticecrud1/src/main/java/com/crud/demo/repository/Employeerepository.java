package com.crud.demo.repository;

import org.springframework.data.repository.CrudRepository;


import com.crud.demo.model.Employee;


public interface Employeerepository extends CrudRepository<Employee, Long> {

	
}
