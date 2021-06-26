package hrms.hrms.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.CurriculumVitaeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumvitaes")
public class CurriculumVitaesController {

private CurriculumVitaeService curriculumvitaeService;
    
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumvitaeService) {
		super();
		this.curriculumvitaeService = curriculumvitaeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumvitaeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		
		return this.curriculumvitaeService.add(curriculumVitae);
		
	}
	
	@GetMapping("/getdetail")
	public ResponseEntity<?> getallbyjobseekerid(@RequestParam int id, @RequestParam int jobseekerId) {
		
		return ResponseEntity.ok(this.curriculumvitaeService.getByJobseekerId(id , jobseekerId));
	}
	
	@PostMapping("/uploadPhoto")
	public Result uploadPhoto(@RequestParam int cvId, @RequestParam("file") MultipartFile multipartFile) throws IOException{
		
		return curriculumvitaeService.uploadPhoto(cvId, multipartFile);
	}
	
	
	
}
