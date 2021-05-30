package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.JobAdvert;


public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();
}
