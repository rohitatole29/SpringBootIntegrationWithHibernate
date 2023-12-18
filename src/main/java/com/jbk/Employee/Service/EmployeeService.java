package com.jbk.Employee.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jbk.Employee.Dao.EmployeeDao;
import com.jbk.Employee.Entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public Employee insert(@RequestBody Employee employee) {
		return dao.insert(employee);
	}

	public Employee update(@RequestBody Employee employee) {
		return dao.update(employee);
	}

	public Employee delete(@PathVariable int id) {
		return dao.delete(id);
	}

	public List<Employee> allEmployeeDetails() {
		return dao.allEmployeeDetails();
	}

	public Employee singleRecordShow(@PathVariable int id) {
		return dao.singleRecordShow(id);
	}

	public ArrayList<Employee> insertMultiple(@RequestBody ArrayList<Employee> list) {
		return dao.insertMultiple(list);
	}

	public List<Employee> updateMultiple(@RequestBody List<Employee> list) {
		return dao.updateMultiple(list);
	}
}
