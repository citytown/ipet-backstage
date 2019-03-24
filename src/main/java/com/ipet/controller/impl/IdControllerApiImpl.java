package com.ipet.controller.impl;

import org.springframework.web.bind.annotation.RestController;

import com.ipet.controller.IdControllerApi;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;
import com.ipet.util.MyUIDUtils;

@RestController
public class IdControllerApiImpl implements IdControllerApi{

	@Override
	public ApiResult getRandomId() {
		ApiResult result = new ApiResult();
		String id = MyUIDUtils.getId12();
		result.setStatus(ApiStatus.STATUS_OK);
		result.setResult(id);
		return result;
	}

}
