package com.encryptionApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encryptionApp.service.CryptoFactory;
import com.encryptionApp.vo.CryptoBaseRequest;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;
import com.encryptionApp.vo.RestfulResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "crypto")
public class CryptoController {

	@Autowired
	private CryptoFactory cryptoFactory;

	/**
	 * @see 進行資料加密
	 * @param CryptoBaseRequest
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行資料加密", notes = "進行資料加密")
	@RequestMapping(value = "encrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<EncryptResult> encrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		return new RestfulResponse<EncryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getEncryptResult(cryptoTextRequest));
	}
	
	/**
	 * @see 進行資料解密
	 * @param CryptoBaseRequest
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行資料解密", notes = "進行資料解密")
	@RequestMapping(value = "decrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<DecryptResult> decrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		return new RestfulResponse<DecryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getDecryptResult(cryptoTextRequest));
	}
	
//	/**
////	 * @see 產生金鑰
////	 * @return
////	 * @throws Exception 
////	 * @throws NoSuchAlgorithmException 
////	 */
//	@ApiOperation(value = "產生金鑰", notes = "產生金鑰")
//	@RequestMapping(value = "createAESKey", method = RequestMethod.POST)
//	@ResponseBody
//	public RestfulResponse<SymmetricCreateKeyResult>createAESKey(@Valid @RequestBody CreateKeyRequest createKeyRequest) throws Exception {
//		BaseCreateKeyResult gg = cryptoFactory.getCryptoAlgorithm(createKeyRequest).createKey(createKeyRequest);
//		return null;
////		return new RestfulResponse<SymmetricCreateKeyResult>(cryptoFactory.getCryptoAlgorithm(createKeyRequest).createKey(createKeyRequest));
//	}
}

