package com.ipet.controller.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ipet.controller.FileControllerApi;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;

@RestController
public class FileControllerApiImpl implements FileControllerApi {

	@Override
	public ApiResult fileUpload(@RequestParam(value = "file", required = true) MultipartFile file,
			@PathVariable(value = "type", required = true) String type) {
		ApiResult result = new ApiResult();
		String fileName = file.getOriginalFilename();
		String contextPath ="";//项目路径
		try {
			contextPath = ResourceUtils.getURL("").getPath()  + "image/"  + type;
			if(!new File(contextPath).exists()){
				new File(contextPath).mkdirs();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("项目路径出错");
			return result;
		}
		String filePath = contextPath + "/" + fileName;
		try {
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(bytes);
			stream.close();
			result.setStatus(ApiStatus.STATUS_OK);
			result.setResult("上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("上传出错");
		}
		return result;
	}

	@Override
	public ApiResult fileBatchDel(
			@RequestParam(value = "一次性删除多个文件，ids为多个文件的id", required = true) @RequestBody String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
