package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.core.utilities.business.BusinessRules;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<List<Jobseeker>> getAll() {
		
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Jobseeker jobseeker) {
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult();
	}

	@Override
	public DataResult<Jobseeker> getByIdentificationNumber(String identificationNumber) {
		
		var result =BusinessRules.Run(checkIdentityNumberExists(identificationNumber));
		
		if(result!=null) {
			return new ErrorDataResult<Jobseeker>();
		}
		
		return new SuccessDataResult<Jobseeker>(jobseekerDao.findByIdentificationNumber(identificationNumber));
		
	}

	private Result checkIdentityNumberExists(String identificationNumber) {
		
        if(this.jobseekerDao.findByIdentificationNumber(identificationNumber).equals(null)) {
            return new ErrorResult("Tckn bulunamadı");
        }
        
        return new SuccessResult();
    }
	
	
}
