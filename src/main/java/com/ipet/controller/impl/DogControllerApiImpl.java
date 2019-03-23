package com.ipet.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.config.PageResultBean;
import com.ipet.controller.DogControllerApi;
import com.ipet.model.Dog;
import com.ipet.model.DogParams;
import com.ipet.model.User;
import com.ipet.service.DogService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;
import com.ipet.util.MyUIDUtils;

import io.swagger.annotations.ApiParam;

@RestController
public class DogControllerApiImpl implements DogControllerApi{

	@Autowired
	private DogService dogService;
	
	
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
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize) {
		ApiResult ar = new ApiResult();
		try {
			PageResultBean<Dog> list = dogService.pageGetUsers(pageNum, pageSize);
			ar.setResult(list);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult addDog(@ApiParam(value="狗信息",required=true) @RequestBody DogParams dogParams) {
		ApiResult ar = new ApiResult();
		String id = MyUIDUtils.getId12();
		Dog dog = new Dog(id,dogParams.getBreed(), dogParams.getOriginal(), dogParams.getShape(), dogParams.getWoolLength(),
				dogParams.getFunction(), dogParams.getMinLife(), dogParams.getMaxLife(), dogParams.getMinPrice(), 
				dogParams.getMaxPrice(), dogParams.getDescription());
		List<String> photoIds = dogParams.getPhotoIds();
		try {
			dogService.addDog(dog);
			for(String photoId:photoIds){
				//TODO更新狗照片信息
			}
			ar.setResult("添加狗成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("添加狗错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult upateDog(@ApiParam(value="狗信息",required=true) @RequestBody DogParams dogParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult deleteDog(@ApiParam(value="狗Ids",required=true) @RequestBody List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
