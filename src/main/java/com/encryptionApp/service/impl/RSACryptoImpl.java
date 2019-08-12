package com.encryptionApp.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encryptionApp.constant.AlgorithmConstant;
import com.encryptionApp.service.Crypto;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

@Service("RSACryptoImpl")
public class RSACryptoImpl implements Crypto{
	
	@Value(value = "${RSA.publicKey}")
    private String rsaPublicKey;
	
	@Value(value = "${RSA.privateKey}")
    private String rsaPrivateKey;
	
	@Override
	public EncryptResult getEncryptResult(CryptoTextRequest cryptoTextRequest) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
		//初始化
		EncryptResult EncryptResult = new EncryptResult(cryptoTextRequest);
		String text = cryptoTextRequest.getText();
		Cipher cipher = Cipher.getInstance(AlgorithmConstant.RSA.getName());
		PublicKey key = generatePublicKey(rsaPublicKey);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		Base64.Encoder encoder = Base64.getEncoder();
		
		//加密
		String encryptText = encoder.encodeToString(cipher.doFinal(text.getBytes()));
		EncryptResult.setEncryptText(encryptText);
		return EncryptResult;
	}

	@Override
	public DecryptResult getDecryptResult(CryptoTextRequest cryptoTextRequest) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		//初始化
		DecryptResult decryptResult = new DecryptResult(cryptoTextRequest);
		String encryptBase64Text = cryptoTextRequest.getText().replace(" ", "+");
		Cipher cipher = Cipher.getInstance(AlgorithmConstant.RSA.getName());
		PrivateKey key = generatePrivateKey(rsaPrivateKey);
		cipher.init(Cipher.DECRYPT_MODE, key);
		Base64.Decoder decoder = Base64.getDecoder();
        
		//解密
		String decryptText = new String(cipher.doFinal(decoder.decode(encryptBase64Text.getBytes("UTF-8"))));
		decryptResult.setDecryptText(decryptText);
		return decryptResult;
	}

	@Override
	public CreateKeyResult createKey(CreateKeyRequest createKeyRequest) throws NoSuchAlgorithmException {
		//初始化
		CreateKeyResult createKeyResult = new CreateKeyResult(createKeyRequest);
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AlgorithmConstant.RSA.getName());
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        Base64.Encoder encoder = Base64.getEncoder();

        //產生key
        String base64PrivateKey = encoder.encodeToString(privateKey.getEncoded());
        String base64PublicKey = encoder.encodeToString(publicKey.getEncoded());
        createKeyResult.setPrivatekey(base64PrivateKey);
        createKeyResult.setPublicKey(base64PublicKey);
        createKeyResult.setType(AlgorithmConstant.RSA.getType());
        return createKeyResult;
	}
	
	//產生私鑰
	private PrivateKey generatePrivateKey(String base64privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Base64.Decoder decoder = Base64.getDecoder();
	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoder.decode(base64privateKey));
	    KeyFactory keyFactory = KeyFactory.getInstance(AlgorithmConstant.RSA.getName());
	    PrivateKey privateKey = keyFactory.generatePrivate(spec);
	    return privateKey;
	}

	//產生公鑰
	private PublicKey generatePublicKey(String base64PublicKey) throws NoSuchAlgorithmException, InvalidKeySpecException{
	    Base64.Decoder decoder = Base64.getDecoder();
	    X509EncodedKeySpec spec = new X509EncodedKeySpec(decoder.decode(base64PublicKey));
	    KeyFactory keyFactory = KeyFactory.getInstance(AlgorithmConstant.RSA.getName());
	    PublicKey publicKey = keyFactory.generatePublic(spec);
	    return publicKey;
	}
}
