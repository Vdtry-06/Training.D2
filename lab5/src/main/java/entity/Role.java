package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleId;
	
	private String roleName;
	private String description;
	
	@OneToMany(mappedBy = "role")
	private List<User> users;
	
	@ManyToMany
	@JoinTable(
	    name = "role_permissions",
	    joinColumns = @JoinColumn(name = "role_id"),
	    inverseJoinColumns = @JoinColumn(name = "permission_id")
	)
	private List<Permission> permissions = new ArrayList<>();
}
