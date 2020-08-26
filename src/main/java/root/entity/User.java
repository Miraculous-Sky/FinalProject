package root.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Data
@Table(name = "dbuser", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable {
	private static final long serialVersionUID = 3610262709543807025L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	protected String fullName;
	protected String email;
	protected String password;
	protected String phoneNumber;
	protected String role;

}
