package com.ipet.service;

import java.util.List;

import com.ipet.model.CollectionAndMark;

public interface CollectionAndMarkService {

	/**
	 * 获取用户收藏
	 * @param userId
	 */
	List<CollectionAndMark> getCollections(String userId);
	
	/**
	 * 获取该用户对狗的批注信息
	 * @param userId
	 * @param dogId
	 */
	CollectionAndMark getRecord(String userId, String dogId);
	
	
	/**
	 * 增加收藏备注记录
	 * @param record
	 */
	void addRecord(CollectionAndMark record);
	
	
	/**
	 * 更新收藏记录
	 * @param record
	 */
	void updateCollection(CollectionAndMark record);
	
	/**
	 * 更新备注记录
	 * @param record
	 */
	void updateContent(CollectionAndMark record);
}
