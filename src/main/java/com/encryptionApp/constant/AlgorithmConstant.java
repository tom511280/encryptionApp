package com.encryptionApp.constant;

public enum AlgorithmConstant {
	/**
	 * BASE64
	 */
	BASE64("1", "BASE64"),

	/**
	 * AES
	 */
	AES("2", "AES"),
	
	/**
	 * BASE64
	 */
	RSA("3", "RSA");

	/**
	 * 代碼
	 */
	private String code;

	/**
	 * 訊息
	 */
	private String message;

	private AlgorithmConstant(String code, String message) {
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
