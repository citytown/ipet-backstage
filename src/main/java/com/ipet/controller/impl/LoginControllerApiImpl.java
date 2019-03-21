package com.ipet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.controller.LoginControllerApi;
import com.ipet.model.LoginParam;
import com.ipet.model.User;
import com.ipet.service.UserService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;

import io.swagger.annotations.ApiParam;

@RestController
public class LoginControllerApiImpl implements LoginControllerApi{

	@Autowired
	private UserService userService;
	
	@Override
	public ApiResult login(@ApiParam(value="登录信息",required=true) @RequestBody LoginParam loginParam ) {
		ApiResult result = new ApiResult();
		try {			
			User user = userService.getUserByUsername(loginParam.getUsername());
			if(user.getPassword().equals(loginParam.getPassword())){
				user.setPassword("");
				result.setStatus(ApiStatus.STATUS_OK);
				result.setResult(user);
			}else{
				result.setStatus(ApiStatus.STATUS_ERROR);
				result.setResult("用户名或密码错误!");
			}
		} catch (Exception e) {
			result.setStatus(ApiStatus.STATUS_ERROR);
			result.setResult("查询出错");
			e.printStackTrace();
		}
		return result;
	}

}
