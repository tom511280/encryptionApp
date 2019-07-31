package com.encryptionApp.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CryptoBaseRequest {
	
	@Valid
	@NotNull(message="運行演算法為必填參數")
	@ApiModelProperty(value = "運行演算法",example="1=base64,2=AES,3=RSA,4=PBE")
	private String algorithm;
	
	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
}
