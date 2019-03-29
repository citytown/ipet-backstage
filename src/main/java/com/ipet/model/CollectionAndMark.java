package com.ipet.model;

/**
 * 
 * @author Administrator
 * @Func 用户收藏备注表实体类
 *
 */
public class CollectionAndMark {

	private String id;
	private String userId;
	private String dogId;
	//是否收藏该犬
	private int collect;
	//备注内容
	private String content;
	
	
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
	public String getDogId() {
		return dogId;
	}
	public void setDogId(String dogId) {
		this.dogId = dogId;
	}
	public int getCollect() {
		return collect;
	}
	public void setCollect(int collect) {
		this.collect = collect;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public CollectionAndMark(String id, String userId, String dogId, int collect, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.dogId = dogId;
		this.collect = collect;
		this.content = content;
	}
	
	
	
	
}
