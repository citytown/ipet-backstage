package com.ipet.mapper;

import java.util.List;

import com.ipet.model.Advice;

public interface AdviceMapper {

	/**
	 * 获取建议列表
	 * @return
	 */
	List<Advice> getAdviceList();
	
	/**
	 * 增加建议
	 * @param advice
	 */
	void addAdvice(Advice advice);
	
	/**
	 * 删除建议
	 * @param id
	 */
	void delAdvice(String id);
}
