package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.entities.concretes.Job;

public interface JobService {
	List<Job> getAll();
}
