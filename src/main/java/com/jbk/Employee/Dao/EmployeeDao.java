package com.jbk.Employee.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jbk.Employee.Entity.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;

@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Employee insert(@RequestBody Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		return employee;
	}

	public ArrayList<Employee> insertMultiple(@RequestBody ArrayList<Employee> list) {

		for (Employee employee2 : list) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(employee2);
			transaction.commit();
		}

		return list;
	}

	public Employee update(@RequestBody Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		return employee;
	}

	public List<Employee> updateMultiple(@RequestBody List<Employee> list) {
		for (Employee employee : list) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
		}
		return list;

	}

	public Employee delete(@PathVariable int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.get(Employee.class, id);
		session.delete(employee);
		transaction.commit();
		return employee;
	}

	public List<Employee> allEmployeeDetails() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		return list;
	}

	public Employee singleRecordShow(@PathVariable int id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

}
