package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.HrmsPersonnel;

public interface HrmsPersonnelDao extends JpaRepository<HrmsPersonnel, Integer>{

}
