package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

public class DecryptResult extends BaseResult{
	
	@ApiModelProperty(value = "解密結果文字")
	private String decryptText;
	
	public DecryptResult(){}
	public DecryptResult(CryptoTextRequest cryptoTextRequest){
		super.setAlgorithm(cryptoTextRequest.getAlgorithm());
	}
	public String getDecryptText() {
		return decryptText;
	}

	public void setDecryptText(String decryptText) {
		this.decryptText = decryptText;
	}
}
