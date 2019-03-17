package com.ipet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipet.config.PageResultBean;
import com.ipet.model.User;

public interface UserService {


	
	/**
	 * 根据页码每页大小获取用户信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageResultBean<User> pageGetUsers(int pageNum, int pageSize);
	
	/**
	 * 增加用户
	 * @param user
	 */
	void addUser(User user);
	
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<User> getUsers();
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);
	
	/**
	 * 更新用户信息
	 * @param id
	 * @param name
	 */
	void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void delUser(int id);
	

}
