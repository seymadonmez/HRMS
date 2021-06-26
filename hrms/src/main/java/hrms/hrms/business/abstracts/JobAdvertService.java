package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDetailDto;


public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();
	Result add(JobAdvert jobAdvert);
	DataResult<List<JobAdvertDetailDto>> getJobAdvertDetails();
	DataResult<List<JobAdvertDetailDto>> getJobAdvertDetailsByEmployerId(int employerId);
	DataResult<List<JobAdvert>> getAllSorted();
	Result closeTheAdvertisement(int jobAdvertisementId);
	Result openTheAdvertisement(int jobAdvertisementId);
	DataResult<List<JobAdvertDetailDto>> getActiveJobAdsByCompanyName(String companyName);
}
