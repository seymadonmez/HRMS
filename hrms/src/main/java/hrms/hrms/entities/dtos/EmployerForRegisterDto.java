package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	private String companyName;
	private String webAddress;
    private String phoneNumber;
	private String email;
	private String password;
	private boolean status;
	private String rePassword;
}
