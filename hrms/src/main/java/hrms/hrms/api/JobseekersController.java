package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;

import hrms.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobseekersController {

	public JobseekerService jobseekerService;
	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Jobseeker jobseeker){
		return this.jobseekerService.add(jobseeker);
	}
	
	@GetMapping("/getByIdentificationNumber")
	public DataResult<Jobseeker> getByIdentificationNumber(String idendificationNumber){
		return this.jobseekerService.getByIdentificationNumber(idendificationNumber);
	}
	
}
