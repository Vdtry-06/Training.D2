package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long positionId;
	private String positionName;
	
	@OneToMany(mappedBy = "position")
	private List<Employee> employees;
}
