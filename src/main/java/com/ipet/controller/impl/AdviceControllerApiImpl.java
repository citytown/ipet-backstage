package com.ipet.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.config.PageResultBean;
import com.ipet.controller.AdviceControllerApi;
import com.ipet.controller.GameControllerApi;
import com.ipet.model.Advice;
import com.ipet.model.Game;
import com.ipet.model.User;
import com.ipet.service.AdviceService;
import com.ipet.service.GameService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;
import com.ipet.util.MyUIDUtils;

import io.swagger.annotations.ApiParam;

@RestController
public class AdviceControllerApiImpl implements AdviceControllerApi {

	@Autowired
	private AdviceService adviceService;

	@Override
	public ApiResult addGame(@ApiParam(value = "意见", required = true) @RequestBody Advice advice) {
		ApiResult result = new ApiResult();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			advice.setId(MyUIDUtils.getId12());
			advice.setSignDate(sdf.format(new Date()));
			adviceService.addAdvice(advice);
			result.setStatus(ApiStatus.STATUS_OK);
			result.setResult("反馈成功");
		} catch (Exception e) {
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("反馈出错");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ApiResult getGameList(@ApiParam(value = "页码", required = true) @PathVariable int pageNum,
			@ApiParam(value = "每页大小", required = true) @PathVariable int pageSize) {
		ApiResult result = new ApiResult();
		try {
			PageResultBean<Advice> list = adviceService.getAdviceList(pageNum, pageSize);
			result.setStatus(ApiStatus.STATUS_OK);
			result.setResult(list);
		} catch (Exception e) {
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("查询出错");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ApiResult delGame(@ApiParam(value = "id", required = true) @RequestParam String id) {
		ApiResult result = new ApiResult();
		try {
			adviceService.delAdvice(id);
			result.setStatus(ApiStatus.STATUS_OK);
			result.setResult("删除成功");
		} catch (Exception e) {
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("删除出错");
			e.printStackTrace();
		}
		return result;
	}

}
