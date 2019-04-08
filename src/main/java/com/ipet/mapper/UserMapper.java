package com.ipet.mapper;

import java.util.List;

import com.ipet.model.User;

/**
 * 
 * @author Administrator
 * @Func
 *
 */
public interface UserMapper {

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
	 * 更新最后登陆时间
	 * @param user
	 */
	void updateLoginTime(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void delUser(String id);
	
	
	/**
	 * 用户名模糊查询
	 * @return
	 */
	List<User> queryUsersByLike(String username);
	
	
}
