package com.encryptionApp.service;

import java.security.InvalidKeyException;

import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

public interface Crypto {
	
	/**
	 * @see 取得加密結果回傳
	 * @param 未加密文本
	 * @return 加密文本
	 * @throws Exception 
	 * @throws InvalidKeyException 
	 */
	public EncryptResult getEncryptResult(CryptoTextRequest cryptoTextRequest) throws InvalidKeyException, Exception;

	/**
	 * @see 取得解密結果回傳
	 * @param 加密文本
	 * @return	未加密文本
	 * @throws Exception 
	 * @throws InvalidKeyException 
	 */
	public DecryptResult getDecryptResult(CryptoTextRequest cryptoTextRequest) throws InvalidKeyException, Exception;
	
	/**
	 * @see 產生金鑰
	 * @param 欲產生的金鑰類型
	 * @return	金鑰
	 */
	public CreateKeyResult createKey(CreateKeyRequest createKeyRequest);

}
