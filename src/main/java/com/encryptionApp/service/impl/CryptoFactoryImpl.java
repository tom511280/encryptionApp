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
	private Crypto base64CryptoImpl;
	
	@Autowired
	@Qualifier("AESCryptoImpl")
	private Crypto aesCryptoImpl;
	
	@Autowired
	@Qualifier("RSACryptoImpl")
	private Crypto rsaCryptoImpl;
	
	@Override
	public Crypto getCryptoAlgorithm(CryptoBaseRequest cryptoBaseRequest) throws Exception {
		String code = cryptoBaseRequest.getAlgorithm();
		
		//回傳對應的演算法實例
		if(code.equals(AlgorithmConstant.BASE64.getCode())) return base64CryptoImpl;
		else if(code.equals(AlgorithmConstant.AES.getCode())) return aesCryptoImpl;
		else if(code.equals(AlgorithmConstant.RSA.getCode())) return rsaCryptoImpl;
		else if(code.equals(AlgorithmConstant.PBE.getCode())) return rsaCryptoImpl;
		else throw new Exception("找不到演算法");
		
	}
}
