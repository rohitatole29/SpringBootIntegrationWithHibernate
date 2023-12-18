package com.jbk.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Employee.Entity.Employee;
import com.jbk.Employee.Service.EmployeeService;

@RestController
public class EmployrrController {
	@Autowired
	private EmployeeService service;

	@PostMapping("insertEmployeeDetails")
	public Employee insert(@RequestBody Employee employee) {
		return service.insert(employee);
	}
	@PutMapping("updateEmployeeDetails")
	public Employee update(@RequestBody Employee employee) {
		return service.update(employee);
	}

	@DeleteMapping("deleteEmployeeDetails/{id}")
	public Employee delete(@PathVariable int id) {
		return service.delete(id);
	}
	@GetMapping("allEmployeeDetails")
	public List<Employee> allEmployeeDetails() {
		return service.allEmployeeDetails();
	}
	@GetMapping("singleEmployeeRecordShow/{id}")
	public Employee singleRecordShow(@PathVariable int id) {
		return service.singleRecordShow(id);
	}
	@PostMapping("insertMultipleEmployeeDetails")
	public ArrayList<Employee> insertMultiple(@RequestBody ArrayList<Employee> list) {
		return service.insertMultiple(list);
	}
	@PutMapping("updateMultipleEmployeeDetails")
	public List<Employee> updateMultiple(@RequestBody List<Employee> list) {
		return service.updateMultiple(list);
	}
}
