package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.ForeignLanguageInformationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ForeignLanguageInformationDao;
import hrms.hrms.entities.concretes.ForeignLanguageInformation;

@Service
public class ForeignLanguageInformationManager implements ForeignLanguageInformationService{

	private ForeignLanguageInformationDao foreignLanguageInformationDao;

	@Autowired
	public ForeignLanguageInformationManager(ForeignLanguageInformationDao foreignLanguageInformationDao) {
		super();
		this.foreignLanguageInformationDao = foreignLanguageInformationDao;
	}
	
	@Override
	public Result add(ForeignLanguageInformation foreignLanguageInformation) {
		
		this.foreignLanguageInformationDao.save(foreignLanguageInformation);

		return new SuccessResult();
	}

	@Override
	public DataResult<List<ForeignLanguageInformation>> getAll() {
		
		return new SuccessDataResult<List<ForeignLanguageInformation>>(this.foreignLanguageInformationDao.findAll());
	}

}
