package com.ipet.mapper;

import java.util.List;
import java.util.Map;

import com.ipet.model.Dog;

/**
 * 
 * @author Administrator
 * @Func
 *
 */
public interface DogMapper {

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
	 * 多条件查询狗
	 * @param username
	 * @return
	 */
	List<Dog> getDogsByCondition(Map<String, String> map);
	
	
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
