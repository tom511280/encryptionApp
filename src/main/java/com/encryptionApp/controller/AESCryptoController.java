package com.encryptionApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encryptionApp.service.CryptoFactory;
import com.encryptionApp.vo.BaseCreateKeyResult;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CryptoBaseRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;
import com.encryptionApp.vo.RestfulResponse;
import com.encryptionApp.vo.SymmetricCreateKeyResult;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "AESCrypto")
public class AESCryptoController {
	
	@Autowired
	private CryptoFactory cryptoFactory;
	
//	/**
//	 * @see 進行AES資料加密
//	 * @param CryptoBaseRequest
//	 * @return
//	 */
//	@ApiOperation(value = "進行AES資料加密", notes = "進行AES資料加密")
//	@RequestMapping(value = "deAESencrypt", method = RequestMethod.POST)
//	@ResponseBody
//	public RestfulResponse<EncryptResult> deAESencrypt(@Valid @RequestBody CryptoBaseRequest cryptoBaseRequest) throws Exception {
//		return new RestfulResponse<EncryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoBaseRequest).getEncryptResult(cryptoBaseRequest));
//	}
//
//	/**
//	 * @see 進行AES資料解密
//	 * @param CryptoBaseRequest
//	 * @return
//	 */
//	@ApiOperation(value = "進行AES資料解密", notes = "進行AES資料解密")
//	@RequestMapping(value = "deAESdecrypt", method = RequestMethod.POST)
//	@ResponseBody
//	public RestfulResponse<DecryptResult> deAESdecrypt(@Valid @RequestBody CryptoBaseRequest cryptoBaseRequest) throws Exception {
//		return new RestfulResponse<DecryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoBaseRequest).getDecryptResult(cryptoBaseRequest));
//	}
//	
//	/**
//	 * @see 產生AES金鑰
//	 * @return
//	 * @throws Exception 
//	 * @throws NoSuchAlgorithmException 
//	 */
//	@ApiOperation(value = "產生AES金鑰", notes = "產生AES金鑰")
//	@RequestMapping(value = "createAESKey", method = RequestMethod.POST)
//	@ResponseBody
//	public RestfulResponse<SymmetricCreateKeyResult>createAESKey(@Valid @RequestBody CreateKeyRequest createKeyRequest) throws Exception {
//		BaseCreateKeyResult gg = cryptoFactory.getCryptoAlgorithm(createKeyRequest).createKey(createKeyRequest);
//		return null;
////		return new RestfulResponse<SymmetricCreateKeyResult>(cryptoFactory.getCryptoAlgorithm(createKeyRequest).createKey(createKeyRequest));
//	}

}
