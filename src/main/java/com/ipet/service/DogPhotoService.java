package com.ipet.service;

import java.util.List;

import com.ipet.model.Dog;
import com.ipet.model.DogPhoto;

public interface DogPhotoService {

	/**
	 * 增加狗照片
	 * @param user
	 */
	void addDogPhoto(DogPhoto photo);
	
	
	
	/**
	 * 根据狗ID查询
	 * @param dogId
	 * @return
	 */
	List<DogPhoto> getDogPhtosByDogId(String dogId);
	
	
	/**
	 * 根据ID查询
	 * @param dogId
	 * @return
	 */
	DogPhoto getDogPhtoById(String id);
	
	/**
	 * 更新狗照片信息
	 * @param photo
	 */
	void updateDogPhoto(DogPhoto photo);
	
	/**
	 * 删除狗照片
	 * @param id
	 */
	void delDogPhoto(String id);
	
	
	/**
	 * 根据狗Id删除其相关照片
	 * @param dogId
	 */
	void delDogPhtoByDogId(String dogId);
}
