package com.ipet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ipet.config.PageResultBean;
import com.ipet.mapper.DogMapper;
import com.ipet.model.Dog;
import com.ipet.service.DogService;

@Service
public class DogServiceImpl implements DogService{

	@Autowired
	private DogMapper dogMapper;

	@Override
	public PageResultBean<Dog> pageGetUsers(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Dog> list = dogMapper.getDogs();
		return new PageResultBean<>(list);
	}

	@Override
	public void addDog(Dog dog) {
		dogMapper.addDog(dog);
	}

	@Override
	public List<Dog> getDogs() {
		List<Dog> list = dogMapper.getDogs();
		return list;
	}

	@Override
	public List<Dog> getDogsByCondition(Map<String, String> map) {
		List<Dog> list = dogMapper.getDogsByCondition(map);
		return list;
	}

	@Override
	public List<Dog> getDogsByBreed(String breed) {
		List<Dog> list = dogMapper.getDogsByBreed(breed);
		return list;
	}

	@Override
	public void updateDog(Dog dog) {
		dogMapper.updateDog(dog);
	}

	@Override
	public void delDog(String id) {
		dogMapper.delDog(id);
	}
	
	

}
