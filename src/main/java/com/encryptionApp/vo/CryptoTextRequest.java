package com.encryptionApp.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CryptoTextRequest extends CryptoBaseRequest{
	@Valid
	@NotNull(message="輸入文本為必填參數")
	@ApiModelProperty(value = "文本")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
