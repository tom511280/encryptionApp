package com.encryptionApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encryptionApp.constant.AlgorithmConstant;
import com.encryptionApp.service.CryptoFactory;
import com.encryptionApp.vo.CreateKeyRequest;
import com.encryptionApp.vo.CreateKeyResult;
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;
import com.encryptionApp.vo.RestfulResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "AESCrypto")
public class AESCryptoController {
	
	@Autowired
	private CryptoFactory cryptoFactory;
	
	/**
	 * @see 進行AES資料加密
	 * @param CryptoBaseRequest
	 * @return RestfulResponse<EncryptResult>
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行AES資料加密", notes = "進行AES資料加密")
	@RequestMapping(value = "doAESEncrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<EncryptResult> doAESEncrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.AES.getCode());
		return new RestfulResponse<EncryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getEncryptResult(cryptoTextRequest));
	}
	
	/**
	 * @see 進行AES資料解密
	 * @param CryptoBaseRequest
	 * @return RestfulResponse<DecryptResult>
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行AES資料解密", notes = "進行AES資料解密")
	@RequestMapping(value = "doAESDecrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<DecryptResult> doAESDecrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.AES.getCode());
		return new RestfulResponse<DecryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getDecryptResult(cryptoTextRequest));
	}
	
	
	/**
	 * @see 產生AES金鑰
	 * @return RestfulResponse<CreateKeyResult>
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@ApiOperation(value = "產生AES金鑰", notes = "產生AES金鑰")
	@RequestMapping(value = "createAESKey", method = RequestMethod.GET)
	@ResponseBody
	public RestfulResponse<CreateKeyResult>createAESKey() throws Exception {
		CreateKeyRequest createKeyRequest = new CreateKeyRequest();
		createKeyRequest.setAlgorithm(AlgorithmConstant.AES.getCode());
		return new RestfulResponse<CreateKeyResult>(cryptoFactory.getCryptoAlgorithm(createKeyRequest).createKey(createKeyRequest));
	}

}
