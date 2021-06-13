package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.dtos.EmployerForRegisterDto;
import hrms.hrms.entities.dtos.JobseekerForRegisterDto;

public interface AuthService {
	Result employerRegister(EmployerForRegisterDto employer);
	Result jobseekerRegister(JobseekerForRegisterDto jobseeker);
}
