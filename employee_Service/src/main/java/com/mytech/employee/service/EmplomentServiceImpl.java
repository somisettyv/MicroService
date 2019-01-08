package com.mytech.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.employee.dao.model.Department;
import com.mytech.employee.dao.model.Employee;
import com.mytech.employee.dao.repository.DepartmentRepository;
import com.mytech.employee.dao.repository.EmployeeRepository;
import com.mytech.employee.model.EmployeeDto;

@Service
public class EmplomentServiceImpl implements EmplomentService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<EmployeeDto> getAllEmployees(long teamId) {
		List<Employee> employees = employeeRepository.findByDepartmentNumber(teamId);

		List<EmployeeDto> employeeDtos = employees.stream().map(p -> new EmployeeDto(p)).collect(Collectors.toList());

		return employeeDtos;
	}

	public void addEmployee(String name, String job, String manager, double salary) {
		
		Department department = departmentRepository.findById(1l).orElse(new Department());
		
		Employee newEmployee = new Employee();
		newEmployee.setName(name);
		newEmployee.setDepartment(department);
		newEmployee.setJobName(job);
		newEmployee.setManagerName(manager);
		newEmployee.setSalary(salary);
		employeeRepository.save(newEmployee);
	}
	
	public void updateEmployee(Long deptNo, Long employeeNumber, Employee employee) {
		Employee currentEmployee = employeeRepository.findById(employeeNumber).orElse(new Employee());

		currentEmployee.setName(employee.getName());
		currentEmployee.setJobName(employee.getJobName());
		currentEmployee.setManagerName(employee.getManagerName());
		currentEmployee.setSalary(employee.getSalary());
		employeeRepository.save(currentEmployee);
	}
}
