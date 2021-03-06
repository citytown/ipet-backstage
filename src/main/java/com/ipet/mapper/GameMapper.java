package com.ipet.mapper;

import java.util.List;

import com.ipet.config.PageResultBean;
import com.ipet.model.Game;

/**
 * 
 * @author Administrator
 * @Func
 *
 */
public interface GameMapper {

	void addGame(Game gaeme);
	
	void delGame(int id);
	
	void updateGame(Game game);
	
	/**
	 * 随机获取一条游戏题目
	 * @return
	 */
	Game getRandomGame();
	
	
	List<Game> getGames();
	
	/**
	 * 查询游戏
	 * @return
	 */
	List<Game> searchGames(String content);
	
	
}
