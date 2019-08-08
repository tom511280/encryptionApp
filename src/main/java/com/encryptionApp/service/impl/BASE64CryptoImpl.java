package com.encryptionApp.service.impl;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.encryptionApp.service.Crypto;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

@Service("BASE64CryptoImpl")
public class BASE64CryptoImpl implements Crypto{

	@Override
	public EncryptResult getEncryptResult(CryptoTextRequest cryptoTextRequest) {
		EncryptResult encryptResult = new EncryptResult(cryptoTextRequest);
		String encryptText = Base64.getEncoder().encodeToString(cryptoTextRequest.getText().getBytes());
		encryptResult.setEncryptText(encryptText);
		return encryptResult;
	}

	@Override
	public DecryptResult getDecryptResult(CryptoTextRequest cryptoTextRequest) {
		DecryptResult decryptResult = new DecryptResult(cryptoTextRequest);
		byte[] decodedBytes = Base64.getDecoder().decode(cryptoTextRequest.getText());
		String decryptText = new String(decodedBytes);
		decryptResult.setDecryptText(decryptText);
		return decryptResult;
	}

	@Override
	public CreateKeyResult createKey(CreateKeyRequest createKeyRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
