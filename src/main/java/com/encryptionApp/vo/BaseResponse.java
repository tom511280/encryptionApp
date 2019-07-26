package com.encryptionApp.vo;

import com.encryptionApp.constant.ResponseConstant;

import io.swagger.annotations.ApiModelProperty;

/**
 * Base Response 物件
 *
 */
public class BaseResponse {

	/**
	 * 回覆代碼
	 */
	@ApiModelProperty(value = "回覆代碼")
	private String code = ResponseConstant.SUCCESS.getCode();

	/**
	 * 回覆代碼訊息
	 */
	@ApiModelProperty(value = "回覆代碼訊息")
	private String msg = ResponseConstant.SUCCESS.getMessage();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "BaseResponse [code=" + code + ", msg=" + msg + "]";
	}

}
