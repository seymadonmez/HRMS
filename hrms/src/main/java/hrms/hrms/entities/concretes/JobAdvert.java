package hrms.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnoreProperties({"id","website","password","email"})
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "position_id")
	private Position position;
	
	
	@Column(name = "min_salary",nullable = true)
    private Double minSalary;

    @Column(name = "max_salary",nullable = true)
    private Double maxSalary;
	
	@Column(name = "status",nullable = false)
	private boolean status;
	
	@Column(name = "open_position_count", nullable = false)
    private int openPositionCount;
	
	@Column(name = "application_deadline")
    private LocalDate applicationDeadline;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id")
    private City city;
	
	@JsonIgnore
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "insert_date")
    private Date insertDate;
	
	public JobAdvert(String description, Double minSalary, Double maxSalary, int openPositionCount,
			LocalDate applicationDeadline, Date insertDate, boolean status) {
		this.description = description;
		 this.minSalary = minSalary;
		 this.maxSalary = maxSalary;
		 this.openPositionCount = openPositionCount;
		 this.applicationDeadline = applicationDeadline;
		 this.insertDate = insertDate;
		 this.status = status;
		}
	
}
