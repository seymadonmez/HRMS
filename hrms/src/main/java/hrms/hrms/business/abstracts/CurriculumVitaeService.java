package hrms.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	 Result add(CurriculumVitae curriculumVitae);
	 DataResult<List<CurriculumVitae>> getAll();
	 DataResult<CurriculumVitae> getByJobseekerId(int id,int jobseekerId);
	 Result uploadPhoto(int cvId, MultipartFile file) throws IOException;
}
