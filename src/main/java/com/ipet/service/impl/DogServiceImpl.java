package com.ipet.service.impl;

import java.util.ArrayList;
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
	public void addDog(Dog dog) {
		dogMapper.addDog(dog);
	}

	@Override
	public List<Dog> getDogs() {
		List<Dog> list = dogMapper.getDogs();
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

	@Override
	public List<Map<String, String>> getDogsByCondition(Map<String, String> map,int pageNum,int pageSize) {
		List<Map<String, String>> list = dogMapper.getDogsByCondition(map);
		List<Map<String, String>> showList = new ArrayList<>();
		if(pageSize > list.size()){			
			return list;
		}else{
			int index = pageNum * pageSize -1;
			for(int i = index ; i < list.size();i++){
				if(i >= list.size()){
					break;
				}else{
					showList.add(list.get(i));
				}
			}
			return showList;
		}
	}

	@Override
	public Dog getDogInfo(String id) {
		return dogMapper.getDogInfo(id);
	}
	
	

}
