package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

public class CryptoBaseRequest {
	
	//運行演算法
	@ApiModelProperty(required = false, example=" ")
	private String algorithm;
	
	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
}
