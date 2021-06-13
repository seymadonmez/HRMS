package hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "positions")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "positionId")
	private int positionId;
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy = "position",fetch = FetchType.LAZY)
	@JsonIgnore()
	private List<JobAdvert> jobAdverts;
}
