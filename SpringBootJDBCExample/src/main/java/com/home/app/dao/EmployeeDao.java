package com.home.app.dao;

import java.util.List;

import com.home.app.model.Employee;

public interface EmployeeDao {
	
	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(int employeeId);
	public abstract void updateEmployeeByid(int employeeId,String newEmail);
	public abstract void deleteEmployeeByid(int employeeId);

}
