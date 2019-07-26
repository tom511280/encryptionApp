package com.encryptionApp.constant;

/**
 * 回覆常數
 *
 */
public enum ResponseConstant {

	/**
	 * 成功
	 */
	SUCCESS("0000", "success"),

	/**
	 * 失敗
	 */
	FAIL("9999", "fail");

	/**
	 * 代碼
	 */
	private String code;

	/**
	 * 訊息
	 */
	private String message;

	private ResponseConstant(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
