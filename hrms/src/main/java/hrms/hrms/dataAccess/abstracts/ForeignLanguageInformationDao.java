package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.ForeignLanguageInformation;

public interface ForeignLanguageInformationDao extends JpaRepository<ForeignLanguageInformation,Integer> {

}
