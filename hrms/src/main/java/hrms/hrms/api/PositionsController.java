package hrms.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.PositionService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
@CrossOrigin
public class PositionsController {

	public PositionService positionService;
	@Autowired
	public PositionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Position position){
		return this.positionService.add(position);
	}
	
}
