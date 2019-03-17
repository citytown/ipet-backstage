package com.ipet.service.impl;

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
	public void delUser(int id) {
		userMapper.delUser(id);
	}

	@Override
	public User getUserByUsername(String username) {
		User user = userMapper.getUserByUsername(username);
		return user;
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

}
