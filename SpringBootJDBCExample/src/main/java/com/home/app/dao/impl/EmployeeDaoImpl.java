package com.home.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.home.app.dao.EmployeeDao;
import com.home.app.model.Employee;
import com.home.app.model.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String sql="insert into employee(employee_name,email,salary)values(?,?,?)";
		int update = jdbcTemplate.update(sql, employee.getEmployeeName(),employee.getEmail(),employee.getSalary());
		if(update>0)
			System.out.println("Employee created successfully!!!!");
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		String sql="select * from employee where employee_id=?";
		Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(),employeeId);
		return employee;
	}

	@Override
	public void updateEmployeeByid(int employeeId, String newEmail) {
		String sql="update employee set email=? where employee_id=?";
		int update = jdbcTemplate.update(sql, newEmail,employeeId);
		if(update>0)
			System.out.println("Employee updated successfully!!!!");
	}

	@Override
	public void deleteEmployeeByid(int employeeId) {
		String sql="delete from employee where employee_id=?";
		int update = jdbcTemplate.update(sql,employeeId);
		if(update>0)
			System.out.println("Employee deleted successfully!!!!");
	}

}
