package hrms.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="hrms_personnels")
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "user_id")
@AllArgsConstructor
@NoArgsConstructor

public class HrmsPersonnel extends User {
	

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "insert_date")
	private LocalDate insertDate;
	
	@Column(name = "status")
	private Boolean status;
}
