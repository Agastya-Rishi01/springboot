package com.crud.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.model.Employee;
import com.crud.demo.repository.Employeerepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeeService {

	@Autowired
	Employeerepository employeerepository;
	public void createEmployee(Employee emp)
	{
		log.debug("In createEmployee Method of EmployeeService");
		employeerepository.save(emp);
		log.debug("Exiting createEmployee Method of EmployeeService");
	}
	public Optional<Employee> findEmployeebyId(long id)
	{
		log.debug("In findEmployeebyId Method of EmployeeService");
		return employeerepository.findById(id);
	}
	public void deleteEmployeebyId(long id)
	{
		log.debug("In deleteEmployeebyId Method of EmployeeService");
		employeerepository.deleteById(id);
		log.debug("Exiting deleteEmployeebyId Method of EmployeeService");
	}
	public void updateEmployee(Employee emp)
	{
		log.debug("In updateEmployee Method of EmployeeService");
		Boolean exist=employeerepository.existsById(emp.getId());
		if(exist)
		{
			employeerepository.save(emp);
		}
		log.debug("Exiting updateEmployee Method of EmployeeService");
	}
}
