package com.ipet.mapper;

import java.util.List;
import java.util.Map;

import com.ipet.model.Dog;
import com.ipet.model.DogPhoto;

/**
 * 
 * @author Administrator
 * @Func
 *
 */
public interface DogPhotoMapper {

	/**
	 * 增加狗照片
	 * @param user
	 */
	void addDogPhoto(DogPhoto photo);
	
	
	/**
	 * 根据ID查询
	 * @param dogId
	 * @return
	 */
	DogPhoto getDogPhtoById(String id);
	
	
	
	/**
	 * 根据狗ID查询
	 * @param dogId
	 * @return
	 */
	List<DogPhoto> getDogPhtosByDogId(String dogId);
	
	/**
	 * 删除狗封面信息
	 * @param photo
	 */
	void DelDogCover(String dogId);
	
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
