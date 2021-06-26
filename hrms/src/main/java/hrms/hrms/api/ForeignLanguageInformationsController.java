package hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.ForeignLanguageInformationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ForeignLanguageInformation;

@RestController
@RequestMapping("/api/foreignlanguageinformations")
public class ForeignLanguageInformationsController {

	private ForeignLanguageInformationService foreignLanguageInformationService;
    
	@Autowired
	public ForeignLanguageInformationsController(ForeignLanguageInformationService foreignLanguageInformationService) {
		super();
		this.foreignLanguageInformationService = foreignLanguageInformationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageInformation foreignLanguageInformation) {
		
		return this.foreignLanguageInformationService.add(foreignLanguageInformation);		
	}
	
	@GetMapping("/getall")
	public DataResult<List<ForeignLanguageInformation>> getAll(){
		return this.foreignLanguageInformationService.getAll();
	}
}
