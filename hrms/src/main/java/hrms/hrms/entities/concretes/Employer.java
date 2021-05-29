package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tomcat.jni.User;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id") 
	private int employerId;
	
	@Column(name = "company_name") 
	private String companyName;
	
	@Column(name = "website") 
	private String website;
}
