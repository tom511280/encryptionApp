package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

public class DecryptResult {
	
	@ApiModelProperty(value = "演算法")
	private String algorithm;
	
	@ApiModelProperty(value = "解密結果文字")
	private String decryptText;
	
	public DecryptResult(){}
	public DecryptResult(CryptoTextRequest cryptoTextRequest){
		algorithm = cryptoTextRequest.getAlgorithm();
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	public String getDecryptText() {
		return decryptText;
	}

	public void setDecryptText(String decryptText) {
		this.decryptText = decryptText;
	}
}
