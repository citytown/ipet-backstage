package com.ipet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipet.model.UpdatePassParam;
import com.ipet.model.User;
import com.ipet.util.ApiResult;
import com.ipet.util.ResultStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="User接口",tags={"User"})
public interface UserControllerApi {

	@ApiOperation(value = "获取用户列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@GetMapping(value = "/users", produces = { "application/json" })
	ApiResult getUsers();
	
	@ApiOperation(value = "分页取用户列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@RequestMapping(value = "/users/{pageNum}/{pageSize}", produces = { "application/json" }, method = RequestMethod.GET)
	ApiResult pageGetUsers(
			@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize);
	
	@ApiOperation(value = "增加用户", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PostMapping(value = "/user", produces = { "application/json" })
	ApiResult addUser(@ApiParam(value="用户信息",required=true) @RequestBody User user);
	
	@ApiOperation(value = "更新用户信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PutMapping(value = "/user", produces = { "application/json" })
	ApiResult upateUser(@ApiParam(value="用户信息",required=true) @RequestBody User user);
	
	@ApiOperation(value = "删除用户", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@DeleteMapping(value = "/user", produces = { "application/json"} )
	ApiResult deleteUser(@ApiParam(value="用户Ids",required=true) @RequestParam String[] ids);
	
	@ApiOperation(value = "查询用户名是否存在", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@GetMapping(value = "/checkUser/{username}", produces = { "application/json"} )
	ApiResult checkUser(@ApiParam(value="username",required=true) @PathVariable String username);
	
	@ApiOperation(value = "用户名模糊查询", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@GetMapping(value = "/likeUsers/{queryUsername}", produces = { "application/json"} )
	ApiResult getUsersBylike(@ApiParam(value="queryUsername",required=true) @PathVariable String queryUsername);
	
	@ApiOperation(value = "密码更新", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@PostMapping(value = "/updatePassword", produces = { "application/json"} )
	ApiResult updatePassword(@ApiParam(value="updatePasswordParam",required=true) @RequestBody UpdatePassParam updateParam);
}
