package com.ipet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipet.mapper.DogPhotoMapper;
import com.ipet.model.Dog;
import com.ipet.model.DogPhoto;
import com.ipet.service.DogPhotoService;

@Service
public class DogPhotoServiceImpl implements DogPhotoService {

	@Autowired
	private DogPhotoMapper dogPhotoMapper;
	
	@Override
	public void addDogPhoto(DogPhoto photo) {
		dogPhotoMapper.addDogPhoto(photo);

	}

	@Override
	public List<Dog> getDogPhtosByDogId(String dogId) {
		List<Dog> list = dogPhotoMapper.getDogPhtosByDogId(dogId);
		return list;
	}

	@Override
	public void updateDogPhoto(DogPhoto photo) {
		dogPhotoMapper.updateDogPhoto(photo);
	}

	@Override
	public void delDogPhoto(String id) {
		dogPhotoMapper.delDogPhoto(id);
	}

	@Override
	public void delDogPhtoByDogId(String dogId) {
		dogPhotoMapper.delDogPhtoByDogId(dogId);
	}

}
