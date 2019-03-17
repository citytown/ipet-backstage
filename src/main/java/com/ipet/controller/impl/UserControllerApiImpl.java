package com.ipet.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.config.PageResultBean;
import com.ipet.controller.UserControllerApi;
import com.ipet.model.User;
import com.ipet.service.UserService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;

import io.swagger.annotations.ApiParam;

@RestController
public class UserControllerApiImpl implements UserControllerApi{

	@Autowired
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(UserControllerApiImpl.class);
	
	@Override
	public ApiResult getUsers() {
		ApiResult ar = new ApiResult();
		try {
			List<User> list = userService.getUsers();
			ar.setResult(list);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找人员错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult addUser(@ApiParam(value="用户信息",required=true) @RequestBody User user) {
		ApiResult ar = new ApiResult();
		try {
			userService.addUser(user);
			ar.setResult("增加用户成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("增加用户错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult pageGetUsers(
			@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize) {
		ApiResult ar = new ApiResult();
		try {
			PageResultBean<User> users = userService.pageGetUsers(pageNum, pageSize);
			ar.setResult(users);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找人员错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult upateUser(@ApiParam(value="用户信息",required=true) @RequestBody User user) {
		ApiResult ar = new ApiResult();
		try {
			//userService.updateUser(id,name);
			ar.setResult("更新用户成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("更新用户错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult deleteUser(@ApiParam(value="用户Ids",required=true) @RequestBody List<Integer> ids) {
		ApiResult ar = new ApiResult();
		try {
			for(int id:ids){				
				userService.delUser(id);
			}
			ar.setResult("删除用户成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("删除用户错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}


}
