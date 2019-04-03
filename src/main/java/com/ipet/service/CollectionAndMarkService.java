package com.ipet.service;

import java.util.Map;

import com.ipet.config.PageResultBean;
import com.ipet.model.CollectionAndMark;

public interface CollectionAndMarkService {

	/**
	 * 获取用户收藏
	 * @param userId
	 */
	PageResultBean<Map<String, String>> getCollections(String userId,int pageNum, int pageSize);
	
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
	
	/**
	 * 删除用户对某只狗的收藏
	 * @param dogId
	 */
	void delRecordByDogId(String dogId);
}
