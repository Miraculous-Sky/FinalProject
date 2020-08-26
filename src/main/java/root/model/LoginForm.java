package root.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginForm {
	@NotBlank(message = "Not blank!")
	@Email(message = "Not email!")
	private String email;
	@NotNull(message = "Not null")
	@Min(value = 6, message = "Password wrong!")
	private String password;

	//
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

	@Override
	public String toString() {
		return "LoginForm [userName=" + email + ", password=" + password + "]";
	}

}
