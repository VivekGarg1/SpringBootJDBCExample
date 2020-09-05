package com.home.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmail(rs.getString("email"));
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}

}
