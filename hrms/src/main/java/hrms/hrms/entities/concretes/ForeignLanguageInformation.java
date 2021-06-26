package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foreign_language_informations")
@Entity
public class ForeignLanguageInformation {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@JoinColumn(name = "cv_id")
	@ManyToOne()
	private CurriculumVitae curriculumVitae; 
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="language_id")
	private ForeignLanguage foreignLanguage;
	
	@Min(1)
	@Max(5)
	@Column(name="language_level") 
	private char languageLevel;
}
