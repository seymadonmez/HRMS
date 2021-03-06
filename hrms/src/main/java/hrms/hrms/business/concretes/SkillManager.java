package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SkillService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.SkillDao;
import hrms.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;	
	
	@Autowired 
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	@Override
	public DataResult<List<Skill>> getAll() {
		
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public Result add(Skill skill) {

		this.skillDao.save(skill);
		return new SuccessResult();
	}

}
