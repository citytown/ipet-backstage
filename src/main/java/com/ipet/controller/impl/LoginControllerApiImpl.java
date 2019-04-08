package com.ipet.controller.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {			
			User user = userService.getUserByUsername(loginParam.getUsername());
			if(null != user &&user.getPassword().equals(loginParam.getPassword())){
				String loginTime = sdf.format(new Date());
				user.setLastLoginDate(loginTime);
				userService.updateLoginTime(user);
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
