package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobService;
import hrms.hrms.dataAccess.abstracts.JobDao;
import hrms.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobdao;

	@Autowired
	public JobManager(JobDao jobdao) {
		super();
		this.jobdao = jobdao;
	}

	@Override
	public List<Job> getAll(){
		
		return this.jobdao.findAll();
	}
	
}
