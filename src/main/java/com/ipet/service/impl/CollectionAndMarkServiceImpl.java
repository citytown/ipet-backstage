package com.ipet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ipet.config.PageResultBean;
import com.ipet.mapper.CollectionAndMarkMapper;
import com.ipet.model.CollectionAndMark;
import com.ipet.service.CollectionAndMarkService;

@Service
public class CollectionAndMarkServiceImpl implements CollectionAndMarkService {

	@Autowired
	private CollectionAndMarkMapper markMapper;

	@Override
	public PageResultBean<Map<String, String>> getCollections(String userId,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, String>> list = markMapper.getCollections(userId);
		return new PageResultBean<>(list);
	}

	@Override
	public CollectionAndMark getRecord(String userId, String dogId) {
		CollectionAndMark record = markMapper.getRecord(userId, dogId);
		return record;
	}

	@Override
	public void addRecord(CollectionAndMark record) {
		markMapper.addRecord(record);
		
	}

	@Override
	public void updateCollection(CollectionAndMark record) {
		markMapper.updateCollection(record);
		
	}

	@Override
	public void updateContent(CollectionAndMark record) {
		markMapper.updateContent(record);
		
	}

	@Override
	public void delRecordByDogId(String dogId) {
		markMapper.delRecordByDogId(dogId);
		
	}


	


}
