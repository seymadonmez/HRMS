package hrms.hrms.entities.dtos;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {

	private String firstName;	
	private String lastName;	
	private String workplaceName;	
	private String position;	
	private LocalDate beginingDate;	
	private LocalDate finishDate;
}
