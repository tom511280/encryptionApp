package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

public class EncryptResult extends BaseResult{
	
	@ApiModelProperty(value = "加密結果文字")
	private String encryptText;
	
	public EncryptResult(){}
	public EncryptResult(CryptoTextRequest cryptoTextRequest){
		super.setAlgorithm(cryptoTextRequest.getAlgorithm());
	}

	public String getEncryptText() {
		return encryptText;
	}

	public void setEncryptText(String encryptText) {
		this.encryptText = encryptText;
	}
}
