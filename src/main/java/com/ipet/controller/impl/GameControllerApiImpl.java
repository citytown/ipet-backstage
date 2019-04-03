package com.ipet.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipet.config.PageResultBean;
import com.ipet.controller.GameControllerApi;
import com.ipet.model.Game;
import com.ipet.service.GameService;
import com.ipet.util.ApiResult;
import com.ipet.util.ApiStatus;

import io.swagger.annotations.ApiParam;

@RestController
public class GameControllerApiImpl implements GameControllerApi{
	
	@Autowired
	private GameService gameService;

	@Override
	public ApiResult addGame(@ApiParam(value="题目相关信息",required=true) @RequestBody Game game) {
			ApiResult ar = new ApiResult();
			try {
				gameService.addGame(game);
				ar.setResult("增加成功");
				ar.setStatus(ApiStatus.STATUS_OK);
			} catch (Exception e) {
				ar.setResult("增加失败");
				ar.setStatus(ApiStatus.STATUS_ERROR);
			}
			return ar;
	}

	@Override
	public ApiResult getGameList(@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize) {
		ApiResult ar = new ApiResult();
		try {
			PageResultBean<Game> list = gameService.getGames(pageNum, pageSize);
			ar.setResult(list);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("查找失败");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult delGame(@ApiParam(value="题目ids",required=true) @RequestParam int[] ids) {
		ApiResult ar = new ApiResult();
		try {
			for(int id :ids){				
				gameService.delGame(id);
			}
			ar.setResult("删除成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("删除失败");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult updateGame(@ApiParam(value="题目",required=true) @RequestBody Game game) {
		ApiResult ar = new ApiResult();
		try {
			gameService.updateGame(game);
			ar.setResult("更新成功");
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("更新失败");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

	@Override
	public ApiResult getRandomGame() {
		ApiResult ar = new ApiResult();
		try {
			Game game = gameService.getRandomGame();
			ar.setResult(game);
			ar.setStatus(ApiStatus.STATUS_OK);
		} catch (Exception e) {
			ar.setResult("更新失败");
			ar.setStatus(ApiStatus.STATUS_ERROR);
		}
		return ar;
	}

}
