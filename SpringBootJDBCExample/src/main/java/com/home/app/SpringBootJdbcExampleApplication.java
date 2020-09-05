package com.home.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.home.app.dao.EmployeeDao;
import com.home.app.model.Employee;

@SpringBootApplication
public class SpringBootJdbcExampleApplication implements CommandLineRunner {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createEmployee();
		getEmployeeById();
		//updateEmployeeById();
		//deleteEmployeeById();
		System.out.println("DataSource: "+dataSource);
	}

	private void deleteEmployeeById() {
		int employeeId=2;
		employeeDao.deleteEmployeeByid(employeeId);
	}

	private void updateEmployeeById() {
		int employeeId=1;
		String newEmail="r@gmail.com";
		employeeDao.updateEmployeeByid(employeeId, newEmail);
	}

	private void getEmployeeById() {
		int employeeId=1;
		Employee employee = employeeDao.getEmployeeById(employeeId);
		if(employee!= null)
			System.out.println(employee);
	}

	private void createEmployee() {
		Employee employee=new Employee();
		employee.setEmail("s@gmail.com");
		employee.setEmployeeName("Shubham");
		employee.setSalary(15000.0);
		employeeDao.createEmployee(employee);
	}

}
