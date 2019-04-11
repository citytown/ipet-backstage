package com.ipet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipet.config.PageResultBean;
import com.ipet.mapper.AdviceMapper;
import com.ipet.model.Advice;
import com.ipet.service.AdviceService;

@Service
public class AdviceServiceImpl implements AdviceService{

	
	@Autowired
	private AdviceMapper adviceMapper;
	
	@Override
	public PageResultBean<Advice> getAdviceList(int pageNum, int pageSize) {
		List<Advice> list = adviceMapper.getAdviceList();
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
