package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerForRegisterDto {
	private String firstName;
	private String lastName;
	private String nationalityId;
	private int yearOfBirth;
	private String email;
	private String password;
	private boolean status;

}
