package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EducationInformationService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EducationInformationDao;
import hrms.hrms.entities.concretes.EducationInformation;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationInformationDao;

	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}
	
	@Override
	public Result add(EducationInformation educationInformation) {
		
		this.educationInformationDao.save(educationInformation);

		return new SuccessResult();
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.findAll());
	}

}
