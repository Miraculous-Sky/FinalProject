package root.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {

	@NotBlank
	@Email
	private String loginEmail;

	@NotBlank
	private String loginPassword;

}
