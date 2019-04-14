package com.ipet.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipet.model.Game;
import com.ipet.model.LoginParam;
import com.ipet.util.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 游戏控制类
 * @author S0105
 *
 */
@Api(value="Game",tags={"Game"})
public interface GameControllerApi {

	@ApiOperation(value = "增加游戏题目", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PostMapping(value = "/game", produces = { "application/json" })
	ApiResult addGame(@ApiParam(value="题目相关信息",required=true) @RequestBody Game game);
	
	@ApiOperation(value = "分页获取游戏列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@GetMapping(value = "/games/{pageNum}/{pageSize}", produces = { "application/json" })
	ApiResult getGameList(@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize);
	
	@ApiOperation(value = "删除游戏题目", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@DeleteMapping(value = "/game", produces = { "application/json" })
	ApiResult delGame(@ApiParam(value="题目ids",required=true) @RequestParam int[] ids);
	
	@ApiOperation(value = "更新游戏题目", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PutMapping(value = "/game", produces = { "application/json" })
	ApiResult updateGame(@ApiParam(value="题目",required=true) @RequestBody Game game);
	
	@ApiOperation(value = "随机获取游戏题目", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@GetMapping(value = "/randomGame", produces = { "application/json" })
	ApiResult getRandomGame();
	
	@ApiOperation(value = "搜索题目", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@GetMapping(value = "/game/likeContent/{pageNum}/{pageSize}/{content}", produces = { "application/json" })
	ApiResult searchGame(@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize,
			@ApiParam(value="内容",required=true) @PathVariable String content);
	
}
