package com.ipet.model;

/**
 * 
 * @author Administrator
 * @Func 用户表
 *
 */
public class User {

	//id
	private int id;
	//用户名
	private String username;
	//密码
	private String password;
	//昵称
	private String nickName;
	//头像Url
	private String avatarUrl;
	//角色id
	private int roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public User(){
		
	}
	
	
	
}
