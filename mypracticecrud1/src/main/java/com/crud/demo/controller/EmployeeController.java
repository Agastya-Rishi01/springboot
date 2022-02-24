package com.crud.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.custom.messagebeans.ErrorMessage;
import com.crud.demo.custom.messagebeans.SuccessMessage;
import com.crud.demo.model.Employee;
import com.crud.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp)
	{	
		log.debug("In createEmployee Method of EmployeeController");
		employeeService.createEmployee(emp);
		log.debug("Exiting createEmployee Method of EmployeeController");
		return new ResponseEntity<>(new SuccessMessage("Employee created successfully",HttpStatus.CREATED.toString()),HttpStatus.CREATED);				
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> findEmployeebyId(@PathVariable Long id)
	{
		log.debug("In findEmployeebyId Method of EmployeeController");
		Optional<Employee> emp = employeeService.findEmployeebyId(id);
		log.debug("Exiting findEmployeebyId Method of EmployeeController");
		return new ResponseEntity<>(emp.get(),HttpStatus.FOUND );
		
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployeebyId(@PathVariable Long id)
	{		
		log.debug("In deleteEmployeebyId Method of EmployeeController");
		employeeService.deleteEmployeebyId(id);
		log.debug("Exiting deleteEmployeebyId Method of EmployeeController");
		return new ResponseEntity<>(new SuccessMessage("Employee Deleted Successfully",HttpStatus.OK.toString()),HttpStatus.OK);
		
	}
	@PutMapping("/employee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp)
	{
		log.debug("In updateEmployee Method of EmployeeController");
		employeeService.updateEmployee(emp);
		log.debug("Exiting updateEmployee Method of EmployeeController");
		return new ResponseEntity<>(new SuccessMessage("Employee Updated Successfully",HttpStatus.CREATED.toString()),HttpStatus.CREATED);
		
	}
}
