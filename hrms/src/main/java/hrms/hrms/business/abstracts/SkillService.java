package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Skill;

public interface SkillService {

	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
}
