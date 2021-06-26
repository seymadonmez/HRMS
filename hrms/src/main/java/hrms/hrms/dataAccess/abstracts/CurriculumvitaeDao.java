package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumvitaeDao extends JpaRepository<CurriculumVitae, Integer> {

	CurriculumVitae getById(int id);
	CurriculumVitae getByIdAndJobseeker_userId(int id,int jobseekerId);
	List<CurriculumVitae> getByJobseeker_userId(int jobseekerId);
	
}
