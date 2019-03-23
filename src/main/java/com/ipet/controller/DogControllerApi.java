package com.ipet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipet.model.DogParams;
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
	
	@ApiOperation(value = "分页取狗列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@RequestMapping(value = "/dogs/{pageNum}/{pageSize}", produces = { "application/json" }, method = RequestMethod.GET)
	ApiResult pageGetDogs(
			@ApiParam(value="页码",required=true) @PathVariable int pageNum,
			@ApiParam(value="每页大小",required=true) @PathVariable int pageSize);
	
	@ApiOperation(value = "增加狗", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PostMapping(value = "/dog", produces = { "application/json" })
	ApiResult addDog(@ApiParam(value="狗信息",required=true) @RequestBody DogParams dogParams);
	
	@ApiOperation(value = "更新狗信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PutMapping(value = "/dog", produces = { "application/json" })
	ApiResult upateDog(@ApiParam(value="狗信息",required=true) @RequestBody DogParams dogParams);
	
	@ApiOperation(value = "删除狗", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class)})
	@DeleteMapping(value = "/dog", produces = { "application/json"} )
	ApiResult deleteDog(@ApiParam(value="狗Ids",required=true) @RequestBody List<Integer> ids);
}
