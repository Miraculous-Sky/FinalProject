package root.model;

public class RegisterForm {
private String fullName;
private String email;
private String password;
private String passwordConfirmation;
//
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
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
public String getPasswordConfirmation() {
	return passwordConfirmation;
}
public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
}
@Override
public String toString() {
	return "RegisterForm [fullName=" + fullName + ", email=" + email + ", password=" + password
			+ ", passwordConfirmation=" + passwordConfirmation + "]";
}

}
