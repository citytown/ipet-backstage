package com.ipet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipet.model.CollectionAndMark;
import com.ipet.service.CollectionAndMarkService;

@Service
public class CollectionAndMarkServiceImpl implements CollectionAndMarkService {

	@Autowired
	private CollectionAndMarkService markService;

	@Override
	public List<CollectionAndMark> getCollections(String userId) {
		List<CollectionAndMark> list = markService.getCollections(userId);
		return list;
	}

	@Override
	public CollectionAndMark getRecord(String userId, String dogId) {
		CollectionAndMark record = markService.getRecord(userId, dogId);
		return record;
	}

	@Override
	public void addRecord(CollectionAndMark record) {
		markService.addRecord(record);
		
	}

	@Override
	public void updateCollection(CollectionAndMark record) {
		markService.updateCollection(record);
		
	}

	@Override
	public void updateContent(CollectionAndMark record) {
		markService.updateContent(record);
		
	}


	


}
