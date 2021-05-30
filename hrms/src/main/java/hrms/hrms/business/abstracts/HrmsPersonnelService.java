package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.HrmsPersonnel;

public interface HrmsPersonnelService {
	DataResult<List<HrmsPersonnel>> getAll();
}
