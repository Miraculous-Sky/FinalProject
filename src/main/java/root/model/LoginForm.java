package root.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LoginForm {
	@NotNull
	private String email;
	@NotNull
	@Min(6)
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
