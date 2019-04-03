package com.ipet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ipet.model.LoginParam;
import com.ipet.util.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 登陆处理控制类
 * @author S0105
 *
 */
@Api(value="Login",tags={"Login"})
public interface LoginControllerApi {

	@ApiOperation(value = "用户登录", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PostMapping(value = "/login", produces = { "application/json" })
	ApiResult login(@ApiParam(value="登录信息",required=true) @RequestBody LoginParam loginParam  );
	
}
