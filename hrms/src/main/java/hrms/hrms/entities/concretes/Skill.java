package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "skill_name")
	private String skillName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "skill")
    private List<CVSkill> cvSkills;
}
