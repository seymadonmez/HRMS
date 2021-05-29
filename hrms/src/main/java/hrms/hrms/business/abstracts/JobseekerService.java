package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {
	List<Jobseeker> getAll();
	void add(Jobseeker jobseeker);
	
}
