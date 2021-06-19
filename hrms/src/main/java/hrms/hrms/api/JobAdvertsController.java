package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDetailDto;



@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
	
private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add") 
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getJobAdvertDetails")
	public DataResult<List<JobAdvertDetailDto>> getJobAdvertDetails(){
		return this.jobAdvertService.getJobAdvertDetails();
	}
	
	@GetMapping("/getJobAdvertDetailsByEmployerId")
	public DataResult<List<JobAdvertDetailDto>> getJobAdvertDetailsByEmployerId(int employerId){
		return this.jobAdvertService.getJobAdvertDetailsByEmployerId(employerId);
	}
	
	@GetMapping("/getAllInsertDateDesc")
	public DataResult<List<JobAdvert>> getAllInsertDateSorted(){
		return this.jobAdvertService.getAllSorted();
	}

}
