package hrms.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_informations")
@Entity
public class EducationInformation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "department_name")
	private String departmentName;
	
	@NotBlank
	@NotNull
	@Column(name = "beginning_date")
	private LocalDate beginningDate;
	
	@Nullable
	@Column(name = "graduation_date")
	private LocalDate graduationDate;
	
	@NotBlank
	@NotNull
    @ManyToOne()
	@JoinColumn(name="school_id")
	private School school; 
	
	@Column(name = "graduated")
	private Boolean graduated;
	
	@NotNull
	@JoinColumn(name = "cv_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae;

}
