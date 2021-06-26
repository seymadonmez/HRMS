package hrms.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.CurriculumVitaeService;
import hrms.hrms.core.adapters.CloudinaryService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CurriculumvitaeDao;
import hrms.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumvitaeDao curriculumVitaeDao;
	private CloudinaryService cloudinaryService;
	
	public CurriculumVitaeManager(CurriculumvitaeDao curriculumVitaeDao,CloudinaryService cloudinaryService) {
		super();		
		this.curriculumVitaeDao=curriculumVitaeDao;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll());
	}

	@Override
	public DataResult<CurriculumVitae> getByJobseekerId(int id, int jobseekerId) {
		
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getByIdAndJobseeker_userId(id, jobseekerId));
	}

	@Override
	public Result uploadPhoto(int cvId, MultipartFile file) throws IOException {
		
		DataResult<Map> result= cloudinaryService.upload(file);
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.getById(cvId);
		curriculumVitae.setPhotoUrl(result.getData().get("url").toString());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Fotoğraf yüklendi.");
	}
}
