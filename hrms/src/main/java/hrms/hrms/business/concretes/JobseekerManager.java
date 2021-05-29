package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.dataAccess.abstracts.JobseekerDao;
import hrms.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService{

	private JobseekerDao jobseekerDao;
	
	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao) {
		super();
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public List<Jobseeker> getAll() {
		
		return this.jobseekerDao.findAll();
	}

	@Override
	public void add(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		
	}


	
	
}
