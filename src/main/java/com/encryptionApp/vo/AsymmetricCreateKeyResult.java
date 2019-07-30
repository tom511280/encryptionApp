package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * @author 80005458
 * @see 非對稱式產生金鑰結果
 */
public class AsymmetricCreateKeyResult extends BaseCreateKeyResult{
	
	@ApiModelProperty(value = "公鑰")
	private String publicKey;
	
	@ApiModelProperty(value = "私鑰")
	private String privatekey;

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivatekey() {
		return privatekey;
	}

	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}	
	
}
