package root.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dbuser", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable {
	private static final long serialVersionUID = 3610262709543807025L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//
	@NotBlank(message = "Not blank!")
	private String fullName;
	//
	@NotBlank(message = "Email blank!")
	@Email(message = "Not email!")
	private String email;
	//
	@Min(value = 6, message = "Password is wrong!")
	private String password;
	@Min(value = 6, message = "Repeat password is wrong!")
	private String repeatPassword;
	@Size(min = 10, max = 11, message = "Invalid!")
	private String phoneNumber;
	private String role;
	@OneToOne
	private Cart cart;
	//
//	@ManyToMany
//	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "roleId") })
//	private Collection<Role> roles;

//	public Collection<Role> getRoles() {
//		return roles;
//	}

//	public void setRoles(Collection<Role> roles) {
//		this.roles = roles;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
