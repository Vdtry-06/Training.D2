package main.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import main.repository.EmployeeRepository;
import main.specification.entity.Employee;
import main.specification.entity.EmployeeSpecification;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> searchEmployees(String name, String department, Integer age) {
		Specification<Employee> spec = Specification
				.where(EmployeeSpecification.hasName(name))
				.and(EmployeeSpecification.hasDepartment(department))
				.and(EmployeeSpecification.hasAgeGreaterThan(age));
	
		return employeeRepository.findAll(spec);
	}
}
