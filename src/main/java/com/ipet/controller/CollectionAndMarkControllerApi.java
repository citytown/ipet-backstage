package com.ipet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ipet.model.CollectionAndMark;
import com.ipet.util.ApiResult;
import com.ipet.util.ResultStatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="CollectionAndMark",tags={"CollectionAndMark"})
public interface CollectionAndMarkControllerApi {

	@ApiOperation(value = "获取收藏列表", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@GetMapping(value = "/collections/{userId}", produces = { "application/json" })
	ApiResult getCollections(@ApiParam(value="userId",required=true) @PathVariable String userId);
	
	@ApiOperation(value = "获取该用户对狗的收藏批注信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@GetMapping(value = "/collectionAndMark/{userId}/{dogId}", produces = { "application/json" })
	ApiResult getCollectionAndMark(@ApiParam(value="userId",required=true) @PathVariable String userId,
			@ApiParam(value="dogId",required=true) @PathVariable String dogId);
	
	
	@ApiOperation(value = "更新该用户对狗的收藏信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PutMapping(value = "/collection", produces = { "application/json" })
	ApiResult updateCollection(@ApiParam(value="CollectionAndMark",required=true) @RequestBody CollectionAndMark record);
	
	@ApiOperation(value = "更新该用户对狗的批注信息", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = ResultStatus.CODE_OK, message = "query Acitivity success", response = ApiResult.class) })
	@PutMapping(value = "/mark", produces = { "application/json" })
	ApiResult updateMark(@ApiParam(value="CollectionAndMark",required=true) @RequestBody CollectionAndMark record);
}
