package hrms.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDetailDto;


public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	List<JobAdvert> findByStatusTrue();

    List<JobAdvert> findByStatusTrueOrderByInsertDate();

        
	List<JobAdvert> getByApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByStatusTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvert> getByStatusTrueAndEmployer_CompanyName(String companyName);

	
	List<JobAdvert> getByPosition_PositionIdIn(List<Integer> jobAdverts);
	
	List<JobAdvert> getByDescriptionStartsWith(String description);
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto"
			+ "(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) "
			+ "From JobAdvert j Inner Join j.employer e Inner Join j.position p "
			+ "Where j.status = true")
	List<JobAdvertDetailDto> getActiveJobAdvertDetails();
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto"
			+ "(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) "
			+ "From JobAdvert j Inner Join j.employer e Inner Join j.position p "
			+ "Where j.status = true and j.id = :id")
	List<JobAdvertDetailDto> getJobAdvertDetailsById(int id);
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto"
			+ "(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) "
			+ "From JobAdvert j Inner Join j.employer e Inner Join j.position p "
			+ "where j.status = true and e.userId = :employerId ")
	List<JobAdvertDetailDto> getJobAdvertDetailsByEmployerId(int employerId);
	
	@Query("Select new hrms.hrms.entities.dtos.JobAdvertDetailDto"
			+ "(j.id, e.companyName, p.name, j.openPositionCount, j.insertDate, j.applicationDeadline, j.status) "
			+ "From JobAdvert j Inner Join j.employer e Inner Join j.position p "
			+ "where j.status = true and e.companyName = :companyName ")
	List<JobAdvertDetailDto> getActiveJobAdsByCompanyName(String companyName);
	
	@Modifying
	@Query("Update JobAdvert set status=false Where id = :jobAdvertisementId")
	void closeTheAdvertisement(@Param("jobAdvertisementId") int jobAdvertisementId); 
	
	@Modifying
	@Query("Update JobAdvert set status=true Where id = :jobAdvertisementId")
	void openTheAdvertisement(@Param("jobAdvertisementId") int jobAdvertisementId); 
	
}
