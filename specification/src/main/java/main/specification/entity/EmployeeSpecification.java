package main.specification.entity;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeeSpecification {
	public static Specification<Employee> hasName(String name) {
		return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			return name != null ? cb.equal(root.get("name"), name) : null;
		};
	}
	
	public static Specification<Employee> hasDepartment(String department) {
		return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			return department != null ? cb.equal(root.get("department"), department) : null;
		};
	}
	
	public static Specification<Employee> hasAgeGreaterThan(Integer age) {
		return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			return age != null ? cb.equal(root.get("age"), age) : null;
		};
	}

}
