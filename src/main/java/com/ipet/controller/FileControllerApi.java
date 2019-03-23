package com.ipet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ipet.util.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 文件处理控制类
 * @author S0105
 *
 */
@Api(value="File接口",tags={"File"})
@RequestMapping("/file")
public interface FileControllerApi {

	@ApiOperation(value = "File 文件上传", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PostMapping(value = "/upload/{type}", produces = { "application/json" })
	ApiResult fileUpload(@RequestParam(value = "file", required = true) MultipartFile file
			,@PathVariable(value = "type", required = true) String type);
	
	@ApiOperation(value = "File 批量文件上传", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PostMapping(value = "/batchUpload/{type}", produces = { "application/json" })
	ApiResult batchFileUpload(
			@RequestParam(value = "batchFile", required = true) HttpServletRequest request,
			@PathVariable(value = "type", required = true) String type);
	
	@ApiOperation(value = "文件批量删除", response = ApiResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success", response = ApiResult.class) })
	@PutMapping(value = "/batchDel", produces = { "application/json" })
	ApiResult fileBatchDel(@RequestParam(value = "一次性删除多个文件，ids为多个文件的id", required = true) @RequestBody String[] ids);
}
