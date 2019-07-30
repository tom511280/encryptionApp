package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 80005458
 * @see 對稱式產生金鑰結果
 */
public class SymmetricCreateKeyResult extends BaseCreateKeyResult{
	
	@ApiModelProperty(value = "金鑰")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
