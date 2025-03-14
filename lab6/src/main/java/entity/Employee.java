package entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long employeeId;
	String firstName;
	String lastName;
	Date dateOfBirth;
	String phoneNumber;
	String address;
	Date hireDate;
	float salary;
	String status;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "position_id",nullable = false)
	Position position;
	
	@ManyToOne
	@JoinColumn(name = "department_id",nullable = false)
	Department department;
	
}
