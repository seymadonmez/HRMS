package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ForeignLanguageInformation;

public interface ForeignLanguageInformationService {

	Result add(ForeignLanguageInformation foreignLanguageInformation);
	DataResult<List<ForeignLanguageInformation>> getAll();
}
