package com.encryptionApp.service.impl;

import org.springframework.stereotype.Service;

import com.encryptionApp.service.Crypto;
import com.encryptionApp.vo.BaseCreateKeyResult;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CryptoBaseRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

@Service("AESCryptoImpl")
public class AESCryptoImpl implements Crypto{

	@Override
	public EncryptResult getEncryptResult(CryptoBaseRequest cryptoBaseRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DecryptResult getDecryptResult(CryptoBaseRequest cryptoBaseRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseCreateKeyResult createKey(CreateKeyRequest createKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
