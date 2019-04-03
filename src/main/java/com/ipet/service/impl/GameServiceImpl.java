package com.ipet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ipet.config.PageResultBean;
import com.ipet.mapper.GameMapper;
import com.ipet.mapper.UserMapper;
import com.ipet.model.Game;
import com.ipet.model.User;
import com.ipet.service.GameService;
import com.ipet.service.UserService;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	private GameMapper gameMapper;
	
	@Override
	public void addGame(Game gaeme) {
		gameMapper.addGame(gaeme);
	}

	@Override
	public void delGame(int id) {
		gameMapper.delGame(id);
	}

	@Override
	public void updateGame(Game game) {
		gameMapper.updateGame(game);
	}

	@Override
	public Game getRandomGame() {
		Game game = gameMapper.getRandomGame();
		return game;
	}

	@Override
	public PageResultBean<Game> getGames(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Game> games = gameMapper.getGames();
		return new PageResultBean<>(games);
	}

	
}
