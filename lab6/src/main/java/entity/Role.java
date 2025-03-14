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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long roleId;
	
	String roleName;
	String description;
	
	@OneToMany(mappedBy = "role")
	List<User> users;
	
	@ManyToMany
	@JoinTable(
	    name = "role_permissions",
	    joinColumns = @JoinColumn(name = "role_id"),
	    inverseJoinColumns = @JoinColumn(name = "permission_id")
	)
	List<Permission> permissions = new ArrayList<>();
}
