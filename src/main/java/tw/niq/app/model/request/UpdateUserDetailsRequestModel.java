package tw.niq.app.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

	@Size(min = 2, message = "First name must at least 2 characters")
	@NotNull(message = "First name cannot be null")
	private String firstName;
	
	@Size(min = 2, message = "Last name must at least 2 characters")
	@NotNull(message = "Last name cannot be null")
	private String lastName;
	
	@Email(message = "Email is invalid")
	private String email;
	
	@Size(min = 8, max = 16, message = "Password must be 8 ~ 16 characters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}
