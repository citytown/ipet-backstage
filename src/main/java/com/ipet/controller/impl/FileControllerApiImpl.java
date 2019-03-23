package com.ipet.controller.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ipet.controller.FileControllerApi;
import com.ipet.model.DogPhoto;
import com.ipet.service.DogPhotoService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;
import com.ipet.util.MyUIDUtils;

@RestController
public class FileControllerApiImpl implements FileControllerApi {
	
	@Autowired
	private DogPhotoService dogPhotoService;

	@Override
	public ApiResult fileUpload(@RequestParam(value = "file", required = true) MultipartFile file,
			@PathVariable(value = "type", required = true) String type) {
		ApiResult result = new ApiResult();
		List<Map<String, String>> fileList = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		String fileName = file.getOriginalFilename();
		String contextPath ="";//项目路径
		try {
			contextPath = ResourceUtils.getURL("").getPath()  + "static/image/"  + type;
			if(!new File(contextPath).exists()){
				new File(contextPath).mkdirs();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("项目路径出错");
			return result;
		}
		try {
			/*byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(contextPath,fileName)));
			stream.write(bytes);
			stream.close();*/
			String url = "";
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(contextPath,fileName));
			if(type.equals("dogPhoto")){//上传照片类型是狗照片，则需要入库
				String id = MyUIDUtils.getId12();
				url = "static/image/" + type +"/" + fileName;
				DogPhoto photo = new DogPhoto(id, "", fileName, url, 1, 0);
				dogPhotoService.addDogPhoto(photo);
			}
			
			map.put("name", fileName);
			map.put("url", url);
			fileList.add(map);
			result.setStatus(ApiStatus.STATUS_OK);
			result.setResult(fileList);
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("上传出错");
		}
		
		return result;
	}

	@Override
	public ApiResult batchFileUpload(
			@RequestParam(value = "batchFile", required = true) HttpServletRequest request,
			@PathVariable(value = "type", required = true) String type) {
		ApiResult result = new ApiResult();
		List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file"); 
		List<Map<String, String>> fileList = new ArrayList<>();
	    MultipartFile orderFile = null;

		String contextPath ="";//项目路径
		try {
			contextPath = ResourceUtils.getURL("").getPath()  + "static/image/"  + type;
			if(!new File(contextPath).exists()){
				new File(contextPath).mkdirs();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("项目路径出错");
			return result;
		}
		for(int i = 0; i< files.size(); i++){
			orderFile = files.get(i);
			String fileName = orderFile.getOriginalFilename(); // 获得上传文件的全名
			System.out.println("这个文件名是" + orderFile.getName());
			if (fileName.length() > 0) {
				Map<String, String> map = new HashMap<>();
				String url = "";
				try {
					FileUtils.copyInputStreamToFile(orderFile.getInputStream(), new File(contextPath, fileName)); // 以上操作为存取到本地文件中
					if(type.equals("dogPhoto")){//上传照片类型是狗照片，则需要入库
						String id = MyUIDUtils.getId12();
						url = "static/image/" + type +"/" + fileName;
						DogPhoto photo = new DogPhoto(id, "", fileName, url, 0, 0);//不是狗封面，暂时上传
						dogPhotoService.addDogPhoto(photo);
					}	
				} catch (Exception ex) {
					result.setStatus(ApiStatus.STATUS_ERROR);
					result.setResult("上传出错");
					ex.printStackTrace();
				}
				map.put("name", fileName);
				map.put("url", url);
				fileList.add(map);
			}
		}
		result.setStatus(ApiStatus.STATUS_OK);
		result.setResult(fileList);
		return null;
	}
	
	@Override
	public ApiResult fileBatchDel(
			@RequestParam(value = "一次性删除多个文件，ids为多个文件的id", required = true) @RequestBody String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
