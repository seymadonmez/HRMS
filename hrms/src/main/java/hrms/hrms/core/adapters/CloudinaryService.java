package hrms.hrms.core.adapters;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
	
	DataResult<Map> delete (String id) throws IOException;
}
