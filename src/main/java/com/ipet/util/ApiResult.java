package com.ipet.util;

import java.io.Serializable;

/**
 * @Description Api接口的統一返回結果
 */
public class ApiResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status = ApiStatus.STATUS_OK;

	private Object result = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
