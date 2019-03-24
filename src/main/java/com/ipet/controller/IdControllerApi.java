package com.ipet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipet.util.ApiResult;
import com.ipet.util.ResultStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="ID接口",tags={"Id"})
public interface IdControllerApi {
	
	@ApiOperation(value = "获取随机数", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@GetMapping(value = "/randomId", produces = { "application/json"} )
	ApiResult getRandomId();
}
