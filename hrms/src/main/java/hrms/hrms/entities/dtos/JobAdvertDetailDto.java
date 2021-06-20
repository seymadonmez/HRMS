package hrms.hrms.entities.dtos;


import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDetailDto {

	private int id;
	private String companyName;
	private String name;
	private int openPositionCount;
	private Date insertDate;
	private LocalDate applicationDeadline;
	private boolean status;
	
	
}
