package com.ipet.service;

import java.util.List;
import java.util.Map;

import com.ipet.config.PageResultBean;
import com.ipet.model.Dog;

public interface DogService {



	
	/**
	 * 增加狗
	 * @param user
	 */
	void addDog(Dog dog);
	
	
	/**
	 * 获取所有狗
	 * @return
	 */
	List<Dog> getDogs();
	
	/**
	 * 获取狗详细信息
	 * @param id
	 * @return 
	 */
	Dog getDogInfo(String id);
	
	/**
	 * 多条件查询狗
	 * @param username
	 * @return
	 */
	List<Map<String, String>> getDogsByCondition(Map<String, String> map,int pageNum,int pageSize);
	
	
	/**
	 * 根据品种名称查询,模糊查询
	 * @param breed
	 * @return
	 */
	List<Dog> getDogsByBreed(String breed);
	
	/**
	 * 更新狗信息
	 * @param dog
	 */
	void updateDog(Dog dog);
	
	/**
	 * 删除狗信息
	 * @param id
	 */
	void delDog(String id);
	

}
