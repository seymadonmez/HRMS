package hrms.hrms.business.concretes;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.AuthService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.adapters.MailService;
import hrms.hrms.core.utilities.business.BusinessRules;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.Jobseeker;


@Service
public class AuthManager implements AuthService {
	private EmployerService employerService;
	private JobseekerService jobseekerService;
	private MailService mailService;
	private UserService userService;

	public AuthManager(EmployerService employerService,JobseekerService jobseekerService,MailService mailService,UserService userService) {
		super();
		this.employerService = employerService;
		this.jobseekerService=jobseekerService;
		this.mailService=mailService;
		this.userService=userService;
	}

	@Override
	public Result employerRegister(Employer employer) {
		
		//var result =BusinessRules.Run(checkEmailExists(employer.getEmail()));
		return null;
	}

	@Override
	public Result jobseekerRegister(Jobseeker jobseeker) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Result checkEmailExists(String email) {
		Result result = this.userService.getByEmail(email);
		
		if (!result.isSuccess()) {
			return new ErrorResult("Email zaten kaydedilmiş");
		}
		return new SuccessResult();
	}
	
}
