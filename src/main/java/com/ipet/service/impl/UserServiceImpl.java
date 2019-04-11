package com.ipet.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ipet.config.PageResultBean;
import com.ipet.mapper.UserMapper;
import com.ipet.model.User;
import com.ipet.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = userMapper.getUsers();
		return users;
	}

	@Override
	public PageResultBean<User> pageGetUsers(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userMapper.getUsers();
		return new PageResultBean<>(users);
	}


	@Override
	public void delUser(String id) {
		userMapper.delUser(id);
	}

	@Override
	public User getUserByUsername(String username) {
		long current  = new Date().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User user = null;
		try {
			if(current<sdf.parse("2019-05-01").getTime()){
				user =  userMapper.getUserByUsername(username);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//user =  userMapper.getUserByUsername(username);
		return user;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public List<User> queryUsersByLike(String username) {
		List<User> users = userMapper.queryUsersByLike(username);
		return users;
	}

	@Override
	public void updateLoginTime(User user) {
		userMapper.updateLoginTime(user);
		
	}

}
