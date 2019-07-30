package com.encryptionApp.service;

import com.encryptionApp.vo.CryptoBaseRequest;

public interface CryptoFactory {
	
	/**
	 * @see 取得演算法
	 * @param 演算法
	 * @return 演算法service
	 * @throws Exception 
	 */
	public Crypto getCryptoAlgorithm(CryptoBaseRequest cryptoBaseRequest) throws Exception;

}
