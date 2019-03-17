package com.ipet.util;

/**
 * @Description Api接口的統一返回狀態
 */
public class ApiStatus {

	public final static String STATUS_OK = "OK";

	public final static String STATUS_ERROR = "ERROR";

	public static boolean isOK(String status) {
		return ApiStatus.STATUS_OK.equals(status);
	}
}
