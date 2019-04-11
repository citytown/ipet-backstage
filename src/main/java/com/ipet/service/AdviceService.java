package com.ipet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipet.config.PageResultBean;
import com.ipet.model.Advice;
import com.ipet.model.Game;
import com.ipet.model.User;

public interface AdviceService {


	/**
	 * 获取建议列表
	 * @return
	 */
	PageResultBean<Advice> getAdviceList(int pageNum,int pageSize);
	
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
