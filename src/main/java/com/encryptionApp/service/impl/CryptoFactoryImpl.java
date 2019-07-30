package com.encryptionApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.encryptionApp.constant.AlgorithmConstant;
import com.encryptionApp.service.Crypto;
import com.encryptionApp.service.CryptoFactory;
import com.encryptionApp.vo.CryptoBaseRequest;

@Service
public class CryptoFactoryImpl implements CryptoFactory{

	@Autowired
	@Qualifier("BASE64CryptoImpl")
	private Crypto bASE64CryptoImpl;
	
	@Autowired
	@Qualifier("AESCryptoImpl")
	private Crypto aESCryptoImpl;
	
	@Autowired
	@Qualifier("RSACryptoImpl")
	private Crypto rSACryptoImpl;
	
	@Override
	public Crypto getCryptoAlgorithm(CryptoBaseRequest cryptoBaseRequest) throws Exception {
		switch (AlgorithmConstant.valueOf(cryptoBaseRequest.getAlgorithm())){
        	case BASE64:
        		return bASE64CryptoImpl;
        	case AES:
        		return aESCryptoImpl;
        	case RSA:
        		return rSACryptoImpl;
        	default:
        		throw new Exception("找不到演算法");
		}
	}
}
