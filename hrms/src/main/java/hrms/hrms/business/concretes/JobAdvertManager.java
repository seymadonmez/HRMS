package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDetailDto;


@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdverdao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdverdao) {
		super();
		this.jobAdverdao = jobAdverdao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll(){
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdverdao.findAll());
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdverdao.save(jobAdvert);
		return new Result(true, "Job advertisement has been saved to the system!");
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getJobAdvertDetails() {
		
		return new SuccessDataResult<List<JobAdvertDetailDto>>(this.jobAdverdao.getJobAdvertDetails());
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getJobAdvertDetailsByEmployerId(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertDetailDto>>(this.jobAdverdao.getJobAdvertDetailsByEmployerId(employerId));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		Sort sort =Sort.by(Sort.Direction.DESC,"insertDate");
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdverdao.findAll(sort));
	
	}
	
}
