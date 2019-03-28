package com.ipet.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ipet.model.Dog;
import com.ipet.util.ApiResult;
import com.ipet.util.ResultStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Dog接口",tags={"Dog"})
public interface DogControllerApi {

	@ApiOperation(value = "获取狗列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@GetMapping(value = "/dogs", produces = { "application/json" })
	ApiResult getDogs();
	
	@ApiOperation(value = "分页取狗概要列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PostMapping(value = "/dogs/{pageNum}/{pageSize}", produces = { "application/json" })
	ApiResult pageGetDogs(
			@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize,
			@ApiParam(value="查询条件",required=true) @RequestBody Map<String, String> queryMap);

	@ApiOperation(value = "查找狗信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@GetMapping(value = "/dog/{dogId}", produces = { "application/json" })
	ApiResult getDogInfo(@ApiParam(value="狗信息",required=true) @PathVariable String dogId);	

	
	@ApiOperation(value = "增加狗", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PostMapping(value = "/dog", produces = { "application/json" })
	ApiResult addDog(@ApiParam(value="狗信息",required=true) @RequestBody  Dog dog);
	
	@ApiOperation(value = "更新狗信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PutMapping(value = "/dog", produces = { "application/json" })
	ApiResult upateDog(@ApiParam(value="狗信息",required=true) @RequestBody Dog dog);
	
	@ApiOperation(value = "删除狗", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@DeleteMapping(value = "/dog", produces = { "application/json"} )
	ApiResult deleteDog(@ApiParam(value="狗Ids",required=true) @RequestBody List<Integer> ids);
}
