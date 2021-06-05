package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.Jobseeker;

public interface AuthService {
	Result employerRegister(Employer employer);
	Result jobseekerRegister(Jobseeker jobseeker);
}
