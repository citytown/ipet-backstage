package com.ipet.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipet.model.Advice;
import com.ipet.model.Game;
import com.ipet.model.LoginParam;
import com.ipet.util.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 意见反馈
 * @author S0105
 *
 */
@Api(value="Advice",tags={"Advice"})
public interface AdviceControllerApi {

	@ApiOperation(value = "增加建议", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PostMapping(value = "/advice", produces = { "application/json" })
	ApiResult addAdvice(@ApiParam(value="意见",required=true) @RequestBody Advice advice);
	
	@ApiOperation(value = "分页建议列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@GetMapping(value = "/advices/{pageNum}/{pageSize}", produces = { "application/json" })
	ApiResult getAdviceList(@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize);
	
	@ApiOperation(value = "删除建议", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@DeleteMapping(value = "/advice", produces = { "application/json" })
	ApiResult delAdvice(@ApiParam(value="id",required=true) @RequestParam String id);
	
	
}
