package com.encryptionApp.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 80005458
 * @see 產生金鑰結果
 */
public class CreateKeyResult extends BaseResult{
	
	@ApiModelProperty(value = "金鑰")
	private String key;
	
	@ApiModelProperty(value = "公鑰")
	private String publicKey;
	
	@ApiModelProperty(value = "私鑰")
	private String privatekey;
	
	@ApiModelProperty(value = "是否為對稱式加密")
	private Boolean isSymmetric;

	public CreateKeyResult(){}
	public CreateKeyResult(CreateKeyRequest createKeyRequest){
		super.setAlgorithm(createKeyRequest.getAlgorithm());
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivatekey() {
		return privatekey;
	}

	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}

	public Boolean getIsSymmetric() {
		return isSymmetric;
	}

	public void setIsSymmetric(Boolean isSymmetric) {
		this.isSymmetric = isSymmetric;
	}
}
