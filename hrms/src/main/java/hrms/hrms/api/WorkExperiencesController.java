package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.WorkExperienceService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperiencesController {

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}

	private WorkExperienceService workExperienceService;
	
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
	}
	
	@GetMapping("/getWorkExperiencesByJobseekerId")
	public DataResult<List<WorkExperience>> getWorkExperiencesByJobseekerId(int jobseekerId){
		return this.workExperienceService.getWorkExperiencesByJobseekerId(jobseekerId);
	}
}
