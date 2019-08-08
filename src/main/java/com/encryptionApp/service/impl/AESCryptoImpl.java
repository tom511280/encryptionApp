package com.encryptionApp.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.text.RandomStringGenerator;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.encryptionApp.constant.AlgorithmConstant;
import com.encryptionApp.service.Crypto;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;

@Service("AESCryptoImpl")
public class AESCryptoImpl implements Crypto{

	private Cipher encryptCipher;
    private Cipher decryptCipher;
    private RandomStringGenerator generator;
    
    @Value(value = "${AES.key}")
    private String aeskey;
    
    //初始化AES加密工具
    private void initEncryptCipher(String key) throws InvalidKeyException, Exception{
    	encryptCipher = Cipher.getInstance(AlgorithmConstant.AES.getMessage());
    	encryptCipher.init(Cipher.ENCRYPT_MODE, this.bulidKey(key));
    }
    
    //初始化AES解密工具
    private void initDecryptCipher(String key) throws InvalidKeyException, Exception{
    	decryptCipher = Cipher.getInstance(AlgorithmConstant.AES.getMessage());
    	decryptCipher.init(Cipher.DECRYPT_MODE, this.bulidKey(key));
    }
    
    //初始化產生key工具
    private void initCreateKey() throws InvalidKeyException, Exception{
    	char[][] pairs = {{'a','z'},{'A','Z'},{'0','9'}};
		generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
    }
    
    
    
    //建立金鑰
    private SecretKey bulidKey(String key) throws Exception{
    	try {
            return new SecretKeySpec(Base64.decodeBase64(key), AlgorithmConstant.AES.getMessage());
        } catch (Exception e) {
            throw new Exception("buildSecretKey Catch Exception", e);
        }
	}
    
	@Override
	public EncryptResult getEncryptResult(CryptoTextRequest cryptoTextRequest) throws InvalidKeyException, Exception {
		//初始化
		EncryptResult encryptResult = new EncryptResult(cryptoTextRequest);
		String text = cryptoTextRequest.getText();
		this.initEncryptCipher(aeskey);
		
		//加密
		try{
	        String result = new String(Hex.encodeHex(this.encryptCipher.doFinal(text.getBytes("UTF-8"))));
	        encryptResult.setEncryptText(result);
		} catch (Exception e) {
            throw new Exception("encrypt Catch Exception", e);
        }
		return encryptResult;
	}

	@Override
	public DecryptResult getDecryptResult(CryptoTextRequest cryptoTextRequest) throws InvalidKeyException, Exception {
		//初始化
		DecryptResult decryptResult = new DecryptResult(cryptoTextRequest);
		String text = cryptoTextRequest.getText();
		this.initDecryptCipher(aeskey);
		
		//解密
		try {
			String result = new String(this.decryptCipher.doFinal(Hex.decodeHex(text.toCharArray())),"UTF-8");
			decryptResult.setDecryptText(result);
        } catch (Exception e) {
            throw new Exception("decrypt Catch Exception", e);
        }
		return decryptResult;
	}

	@Override
	public CreateKeyResult createKey(CreateKeyRequest createKeyRequest) throws InvalidKeyException, Exception {
		//初始化
		CreateKeyResult createKeyResult = new CreateKeyResult(createKeyRequest);
		int keyLength = 32;
		this.initCreateKey();
		String randomString = generator.generate(keyLength);
	
		//產生key
		createKeyResult.setKey(randomString);
		createKeyResult.setIsSymmetric(true);
		return createKeyResult;
	}	
}
