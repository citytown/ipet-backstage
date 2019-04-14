package com.ipet.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ipet.config.PageResultBean;
import com.ipet.model.Game;
import com.ipet.model.User;

public interface GameService {


	void addGame(Game gaeme);
	
	void delGame(int id);
	
	void updateGame(Game game);
	
	/**
	 * 随机获取一条游戏题目
	 * @return
	 */
	Game getRandomGame();
	
	
	/**
	 * 分页查询游戏
	 * @return
	 */
	PageResultBean<Game> getGames(int pageNum,int pageSize);
	
	/**
	 * 查询游戏
	 * @return
	 */
	PageResultBean<Game> searchGames(int pageNum,int pageSize,String content);
	

}
