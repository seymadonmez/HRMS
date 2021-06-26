package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.EducationInformation;

public interface EducationInformationDao extends JpaRepository<EducationInformation,Integer> {

}
