package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

public class BaseResult {
	
	@ApiModelProperty(value = "演算法")
	private String algorithm;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
