package com.ipet.model;

/**
 * 意见反馈实体类
 * @author Administrator
 * @Func
 *
 */
public class Advice {

	
	private String id;
	//userId
	private String userId;
	//建议内容
	private String content;
	//联系email
	private String email;
	//反馈日期
	private String signDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	public Advice(){
		
	}
}
