package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

public class EncryptResult {
	
	@ApiModelProperty(value = "演算法")
	private String algorithm;
	
	@ApiModelProperty(value = "加密結果文字")
	private String encryptText;
	
	public EncryptResult(){}
	public EncryptResult(CryptoTextRequest cryptoTextRequest){
		algorithm = cryptoTextRequest.getAlgorithm();
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getEncryptText() {
		return encryptText;
	}

	public void setEncryptText(String encryptText) {
		this.encryptText = encryptText;
	}
}
