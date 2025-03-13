package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long departmentId;
	private String departmentName;
	private String description;
	
	@OneToMany(mappedBy = "department")
	List<Employee> employees;
}
