package com.encryptionApp.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CryptoBaseRequest {
	
	@Valid
	@NotNull(message="運行演算法為必填參數")
	@ApiModelProperty(value = "運行演算法")
	private String algorithm;
	
	@Valid
	@NotNull(message="輸入文本為必填參數")
	@ApiModelProperty(value = "文本")
	private String text;

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
