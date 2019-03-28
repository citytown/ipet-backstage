package com.ipet.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setRegisterDate(sdf.format(new Date()));
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
			userService.updateUser(user);
			ar.setResult("更新用户成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("更新用户错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult deleteUser(@ApiParam(value="用户Ids",required=true) @RequestParam String[] ids) {
		ApiResult ar = new ApiResult();
		try {
			for(String id:ids){				
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

	@Override
	public ApiResult checkUser(@ApiParam(value="username",required=true) @PathVariable String username) {
		ApiResult ar = new ApiResult();
		try {
			User user = userService.getUserByUsername(username);
			if(user == null){				
				ar.setStatus(ApiStatus.STATUS_OK);
			}else{
				ar.setResult("用户已经存在");
				ar.setStatus(ApiStatus.STATUS_ERROR);
			}
		} catch (Exception e) {
			ar.setResult("查找人员错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult getUsersBylike(@ApiParam(value="queryUsername",required=true) @PathVariable String queryUsername) {
		ApiResult ar = new ApiResult();
		try {
			List<User> users = userService.queryUsersByLike(queryUsername);
			ar.setResult(users);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找人员错误");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}


}
