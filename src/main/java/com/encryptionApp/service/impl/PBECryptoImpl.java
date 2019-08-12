package com.encryptionApp.service.impl;

import java.security.InvalidKeyException;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encryptionApp.constant.AlgorithmConstant;
import com.encryptionApp.service.Crypto;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;



@Service("PBECryptoImpl")
public class PBECryptoImpl  implements Crypto{

	@Value(value = "${PBE.key}")
    private String pbekey;
	
	@Override
	public EncryptResult getEncryptResult(CryptoTextRequest cryptoTextRequest) throws InvalidKeyException, Exception {
		//初始化
		EncryptResult encryptResult = new EncryptResult(cryptoTextRequest);
		String text = cryptoTextRequest.getText();
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();		
		config.setAlgorithm(AlgorithmConstant.PBE.getName());// 加密算法
	    config.setPassword(pbekey);// 秘鑰
	    encryptor.setConfig(config);
	  
	    //加密
	    String encryptText = encryptor.encrypt(text);
	    encryptResult.setEncryptText(encryptText);
		return encryptResult;
	}

	@Override
	public DecryptResult getDecryptResult(CryptoTextRequest cryptoTextRequest) throws InvalidKeyException, Exception {
		//初始化
		DecryptResult decryptResult = new DecryptResult(cryptoTextRequest);
		String text = cryptoTextRequest.getText();
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setAlgorithm(AlgorithmConstant.PBE.getName());// 加密算法
	    config.setPassword(pbekey);// 秘鑰
	    encryptor.setConfig(config);
	    
	    //解密
	    String decryptText = encryptor.decrypt(text);
	    decryptResult.setDecryptText(decryptText);
	    return decryptResult;
	}

	@Override
	public CreateKeyResult createKey(CreateKeyRequest createKeyRequest) throws InvalidKeyException, Exception {
		return new CreateKeyResult();
	}

}
