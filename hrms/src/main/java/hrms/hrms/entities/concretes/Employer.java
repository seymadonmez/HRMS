package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="employer_id", referencedColumnName = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobs"})
public class Employer extends User {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "employer_id") 
//	private int employerId;
	
	@Column(name = "company_name") 
	private String companyName;
	
	@Column(name = "website") 
	private String website;
	
	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	@JsonIgnore()
	private List<JobAdvert> jobAdverts;
	
	public Employer(String email,String password, boolean status, String companyName, String website) {
		super(email,password,status);
		this.companyName = companyName;
		this.website = website;
	}

}
