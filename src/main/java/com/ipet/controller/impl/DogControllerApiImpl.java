package com.ipet.controller.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.classfile.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.config.PageResultBean;
import com.ipet.controller.DogControllerApi;
import com.ipet.model.Dog;
import com.ipet.model.DogParams;
import com.ipet.model.DogPhoto;
import com.ipet.model.User;
import com.ipet.service.DogPhotoService;
import com.ipet.service.DogService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;
import com.ipet.util.MyUIDUtils;

import io.swagger.annotations.ApiParam;

@RestController
public class DogControllerApiImpl implements DogControllerApi{

	@Autowired
	private DogService dogService;
	
	@Autowired
	private DogPhotoService photoService;
	
	
	private static Logger logger = LoggerFactory.getLogger(DogControllerApiImpl.class);

	@Override
	public ApiResult getDogs() {
		ApiResult ar = new ApiResult();
		try {
			List<Dog> list = dogService.getDogs();
			ar.setResult(list);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult pageGetDogs(
			@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize,
			@ApiParam(value="查询条件",required=true) @RequestBody Map<String, String> queryMap) {
		ApiResult ar = new ApiResult();
		try {
			List<Map<String, String>> list = dogService.getDogsByCondition(queryMap, pageNum, pageSize);
			ar.setResult(list);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public ApiResult addDog(@ApiParam(value="狗信息",required=true) @RequestBody Dog dog) {
		ApiResult ar = new ApiResult();
		try {
			dogService.addDog(dog);
			ar.setResult("添加狗成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("添加狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public ApiResult upateDog(@ApiParam(value="狗信息",required=true) @RequestBody  Dog dog) {
		ApiResult ar = new ApiResult();
		try {
			dogService.updateDog(dog);
			ar.setResult("更新狗成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("更新狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public ApiResult deleteDog(@ApiParam(value="狗Ids",required=true) @RequestParam String id) {
		ApiResult ar = new ApiResult();
		try {
			List<DogPhoto> photos = photoService.getDogPhtosByDogId(id);
			for(DogPhoto photo:photos){
				String filePath = ResourceUtils.getURL("").getPath() + "static/" + photo.getUrl();
				new File(filePath).delete();
			}
			photoService.delDogPhtoByDogId(id);
			dogService.delDog(id);
			ar.setResult("删除狗成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("删除狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public ApiResult getDogInfo(@ApiParam(value="狗信息",required=true) @PathVariable String dogId) {
		ApiResult ar = new ApiResult();
		Map<String, Object> map = new HashMap<>();
		try {
			Dog dog = dogService.getDogInfo(dogId);
			map.put("dogInfo", dog);
			List<DogPhoto> photos = photoService.getDogPhtosByDogId(dogId);
			map.put("photos", photos==null?"":photos);
			ar.setResult(map);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}



}
