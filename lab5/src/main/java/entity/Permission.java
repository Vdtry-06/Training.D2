package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permissions")
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long permissionId;
	
	private String permissionName;
	private String description;
	
	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles = new ArrayList<Role>();

}
