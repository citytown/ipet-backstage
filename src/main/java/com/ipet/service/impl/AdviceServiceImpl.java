package com.ipet.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ipet.config.PageResultBean;
import com.ipet.mapper.AdviceMapper;
import com.ipet.model.Advice;
import com.ipet.service.AdviceService;

@Service
public class AdviceServiceImpl implements AdviceService{

	
	@Autowired
	private AdviceMapper adviceMapper;
	
	@Override
	public PageResultBean<Map<String, Object>> getAdviceList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = adviceMapper.getAdviceList();
		return new PageResultBean<>(list);
	}

	@Override
	public void addAdvice(Advice advice) {
		adviceMapper.addAdvice(advice);
	}

	@Override
	public void delAdvice(String id) {
		adviceMapper.delAdvice(id);
	}




	
}
