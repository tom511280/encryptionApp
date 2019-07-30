package com.encryptionApp.service;

import com.encryptionApp.vo.BaseCreateKeyResult;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CryptoBaseRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

public interface Crypto {
	
	/**
	 * @see 取得加密結果回傳
	 * @param 未加密文本
	 * @return 加密文本
	 */
	public EncryptResult getEncryptResult(CryptoBaseRequest cryptoBaseRequest);

	/**
	 * @see 取得解密結果回傳
	 * @param 加密文本
	 * @return	未加密文本
	 */
	public DecryptResult getDecryptResult(CryptoBaseRequest cryptoBaseRequest);
	
	/**
	 * @see 產生金鑰
	 * @param 欲產生的金鑰類型
	 * @return	金鑰
	 */
	public BaseCreateKeyResult createKey(CreateKeyRequest createKeyRequest);

}
