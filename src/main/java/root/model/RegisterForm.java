package root.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegisterForm {

	@NotBlank
	@Email
	private String registerEmail;

	@NotBlank
	private String registerPassword;
	@NotBlank
	private String registerRepeatPassword;

	private String registerName;
}
