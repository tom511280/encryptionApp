package com.encryptionApp.service.impl;

import org.springframework.stereotype.Service;

import com.encryptionApp.service.Crypto;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

@Service("RSACryptoImpl")
public class RSACryptoImpl implements Crypto{

	@Override
	public EncryptResult getEncryptResult(CryptoTextRequest cryptoTextRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DecryptResult getDecryptResult(CryptoTextRequest cryptoTextRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateKeyResult createKey(CreateKeyRequest createKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
