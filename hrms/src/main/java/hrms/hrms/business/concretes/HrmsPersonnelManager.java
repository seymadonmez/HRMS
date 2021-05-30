package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.HrmsPersonnelService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.HrmsPersonnelDao;
import hrms.hrms.entities.concretes.HrmsPersonnel;


@Service
public class HrmsPersonnelManager implements HrmsPersonnelService {

	private HrmsPersonnelDao hrmsPersonnelDao;

	@Autowired
	public HrmsPersonnelManager(HrmsPersonnelDao hrmsPersonnelDao) {
		super();
		this.hrmsPersonnelDao = hrmsPersonnelDao;
	}

	@Override
	public DataResult<List<HrmsPersonnel>> getAll() {
		
		return new SuccessDataResult<List<HrmsPersonnel>>(this.hrmsPersonnelDao.findAll());
	}
}
