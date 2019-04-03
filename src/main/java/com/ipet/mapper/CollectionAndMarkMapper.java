package com.ipet.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ipet.model.CollectionAndMark;

public interface CollectionAndMarkMapper {

	/**
	 * 获取用户收藏
	 * @param userId
	 */
	List<Map<String, String>> getCollections(String userId);
	
	/**
	 * 获取该用户对狗的批注信息
	 * @param userId
	 * @param dogId
	 */
	CollectionAndMark getRecord(@Param("userId") String userId,@Param("dogId") String dogId);
	
	
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
