package main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.service.EmployeeService;
import main.specification.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	 @GetMapping("/search")
    public List<Employee> searchEmployees(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String department,
        @RequestParam(required = false) Integer minAge) {
        return employeeService.searchEmployees(name, department, minAge);
    }
}
