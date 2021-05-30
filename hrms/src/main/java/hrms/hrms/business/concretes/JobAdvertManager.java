package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobdao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobdao) {
		super();
		this.jobdao = jobdao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll(){
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobdao.findAll());
	}
	
}
