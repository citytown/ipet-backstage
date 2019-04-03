package com.ipet.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.config.PageResultBean;
import com.ipet.controller.CollectionAndMarkControllerApi;
import com.ipet.model.CollectionAndMark;
import com.ipet.service.CollectionAndMarkService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;
import com.ipet.util.MyUIDUtils;

import io.swagger.annotations.ApiParam;

@RestController
public class CollectionAndMarkControllerApiImpl implements CollectionAndMarkControllerApi{
	
	@Autowired
	private CollectionAndMarkService remarkService;

	@Override
	public ApiResult getCollections(@ApiParam(value="userId",required=true) @PathVariable String userId,
			@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize) {
		ApiResult ar = new ApiResult();
		try {
			PageResultBean<Map<String, String>> list = remarkService.getCollections(userId, pageNum, pageSize);
			ar.setResult(list);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找我的收藏错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}

	@Override
	public ApiResult getCollectionAndMark(@ApiParam(value="userId",required=true) @PathVariable String userId,
			@ApiParam(value="dogId",required=true) @PathVariable String dogId) {
		ApiResult ar = new ApiResult();
		try {
			CollectionAndMark record = remarkService.getRecord(userId, dogId);
			if(record == null){
				record = new CollectionAndMark(MyUIDUtils.getId12(), userId, dogId, 0, "");
				remarkService.addRecord(record);
			}
			ar.setResult(record);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找收藏信息错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
			e.printStackTrace();
		}
		return ar;
	}


	@Override
	public ApiResult updateCollection(@ApiParam(value="CollectionAndMark",required=true) @RequestBody CollectionAndMark record) {
		ApiResult ar = new ApiResult();
		try {
			remarkService.updateCollection(record);
			ar.setResult("收藏更新成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("收藏更新失败");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult updateMark(@ApiParam(value="CollectionAndMark",required=true) @RequestBody CollectionAndMark record) {
		ApiResult ar = new ApiResult();
		try {
			remarkService.updateContent(record);
			ar.setResult("备注更新成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("备注更新失败");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

}
