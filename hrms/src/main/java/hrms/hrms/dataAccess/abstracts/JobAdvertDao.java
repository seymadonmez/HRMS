package hrms.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDetailDto;


public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	List<JobAdvert> findByStatusTrue();

    List<JobAdvert> findByStatusTrueOrderByInsertDate();

    List<JobAdvert> findByStatusTrueAndEmployer_EmployerId(int employerId);

    JobAdvert findByIdAndEmployer_EmployerId(int jobadvertId, int employerId);
        
	List<JobAdvert> getByApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByStatusTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByStatusTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvert> getByEmployer_EmployerId(int employerId);
	
	List<JobAdvert> getByPosition_PositionId(List<Integer> jobAdverts);
	
	List<JobAdvert> getByDescriptionStartsWith(String description);
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) From JobAdvert j Inner Join j.employer e Inner Join j.position p where j.status = 'true'")
	List<JobAdvertDetailDto> getJobAdvertDetails();
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) From JobAdvert j Inner Join j.employer e Inner Join j.position p where j.status = true j.id = :id")
	List<JobAdvertDetailDto> getJobAdvertDetailsById(int id);
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) From JobAdvert j Inner Join j.employer e Inner Join j.position p where j.status = true e.employer_id = :employerId")
	List<JobAdvertDetailDto> getJobAdvertDetailsByEmployerId(int employerId);
	
}
