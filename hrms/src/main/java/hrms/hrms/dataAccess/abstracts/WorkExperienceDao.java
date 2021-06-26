package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao  extends JpaRepository<WorkExperience,Integer> {

	@Query("Select new hrms.hrms.entities.dtos.WorkExperienceDto"
			+ "(j.firstName,j.lastName,we.workplaceName,we.position.name,we.beginningDate,we.finishDate) "
			+ "From Jobseeker j Inner Join j.curriculumVitaes cv Inner Join cv.workExperiences we "
			+ "Where j.userId =:jobseekerId ORDER BY we.beginningDate DESC")
	List<WorkExperience> getWorkExperiencesOrderByBeginingDateDesc(@Param("jobseekerId") int jobseekerId);
}
