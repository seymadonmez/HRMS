package hrms.hrms.core.adapters;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	
	Cloudinary cloudinary; 
	
	@Autowired
	public CloudinaryManager() {
		//valuesMap.put("cloud_name", "dwy15gvod");
		//valuesMap.put("api_key", "585762491536878"); 
		//valuesMap.put("api_secret", "gnBwKosAU67l9p62MN6GO3oUjT0");
		this.cloudinary = new Cloudinary("cloudinary://585762491536878:gnBwKosAU67l9p62MN6GO3oUjT0@dwcvw0ab8");
	}
	
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		Map upload = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(upload);
	}


	@Override
	public DataResult<Map> delete(String id) throws IOException {
		 Map<String , Boolean> options = new HashMap<>();
	        options.put("invalidate",true);
	        Map result = cloudinary.uploader().destroy(id,options);
	        return new SuccessDataResult<>(result);
	}

}
