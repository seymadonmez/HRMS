package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {
	DataResult<List<Jobseeker>> getAll();
	Result add(Jobseeker jobseeker);
	DataResult<Jobseeker> getByIdentificationNumber(String identificationNumber);
	
}
