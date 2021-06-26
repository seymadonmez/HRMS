package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDetailDto;


@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdverdao) {
		super();
		this.jobAdvertDao = jobAdverdao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll(){
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		return new Result(true, "Job advertisement has been saved to the system!");
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getJobAdvertDetails() {
		
		return new SuccessDataResult<List<JobAdvertDetailDto>>(this.jobAdvertDao.getActiveJobAdvertDetails());
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getJobAdvertDetailsByEmployerId(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertDetailDto>>(this.jobAdvertDao.getJobAdvertDetailsByEmployerId(employerId));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		
		Sort sort =Sort.by(Sort.Direction.DESC,"insertDate");
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort));
	
	}
	
	@Override
	public Result closeTheAdvertisement(int jobAdvertisementId) {
		
		jobAdvertDao.closeTheAdvertisement(jobAdvertisementId);
		
		return new SuccessResult("İlan pasif duruma getirildi");
	}
	
	@Override
	public Result openTheAdvertisement(int jobAdvertisementId) {
		
		jobAdvertDao.openTheAdvertisement(jobAdvertisementId);
		
		return new SuccessResult("İlan aktif edildi");
	}

	@Override
	public DataResult<List<JobAdvertDetailDto>> getActiveJobAdsByCompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertDetailDto>>(this.jobAdvertDao.getActiveJobAdsByCompanyName(companyName));
	}
	
}
