package com.encryptionApp.constant;

public enum AlgorithmConstant {
	/**
	 * BASE64
	 */
	BASE64("1", "BASE64", ""),

	/**
	 * AES
	 */
	AES("2", "AES", "Symmetric"),
	
	/**
	 * RSA
	 */
	RSA("3", "RSA", "Asymmetric"),
	
	/**
	 * PBE
	 */
	PBE("4", "PBEWithMD5AndDES", "Symmetric");

	/**
	 * 代碼
	 */
	private String code;

	/**
	 * 訊息
	 */
	private String name;
	
	/**
	 * 類型
	 */
	private String type;

	private AlgorithmConstant(String code, String name, String type) {
		this.code = code;
		this.name = name;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
}
