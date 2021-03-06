package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.PositionService;
import hrms.hrms.core.utilities.business.BusinessRules;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.PositionDao;
import hrms.hrms.entities.concretes.Position;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}
	
	@Override
	public DataResult<List<Position>> getAll() {
		
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll());
	}

	@Override
	public Result add(Position position) {
		
		Result result=BusinessRules.Run(checkPositionExists(position));
		if(result!=null) {
			return result;
		}
		this.positionDao.save(position);
		return new SuccessResult();
		
	}
	

	@Override
	public DataResult<Position> getByPositionName(String name) {
//		Result result=BusinessRules.Run(checkPositionExists(name));
//		if(result!=null) {
//			return new ErrorDataResult<Position>();
//		}
		return new SuccessDataResult<Position>(positionDao.getByName(name));
	}
	
	private Result checkPositionExists(Position position) {
		if(positionDao.findByName(position.getName()) == null ) {
			
			return new SuccessResult();			
		}		
		
		return new ErrorResult("position already exists!");
	}

}
