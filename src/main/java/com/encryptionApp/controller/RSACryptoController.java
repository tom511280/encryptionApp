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
@RequestMapping(value = "RSACrypto")
public class RSACryptoController {
	
	@Autowired
	private CryptoFactory cryptoFactory;

	/**
	 * @see 進行RSA資料加密
	 * @param CryptoBaseRequest
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行RSA資料加密", notes = "進行RSA資料加密")
	@RequestMapping(value = "doRSAEncrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<EncryptResult> doRSAEncrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.RSA.getCode());
		return new RestfulResponse<EncryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getEncryptResult(cryptoTextRequest));
	}
	
	/**
	 * @see 進行RSA資料解密
	 * @param CryptoBaseRequest
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行RSA資料解密", notes = "進行RSA資料解密")
	@RequestMapping(value = "doRSADecrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<DecryptResult> doRSADecrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.RSA.getCode());
		return new RestfulResponse<DecryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getDecryptResult(cryptoTextRequest));
	}
	
	/**
	 * @see 產生RSA金鑰
	 * @return RestfulResponse<CreateKeyResult>
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@ApiOperation(value = "產生RSA金鑰", notes = "產生RSA金鑰")
	@RequestMapping(value = "createRSAKey", method = RequestMethod.GET)
	@ResponseBody
	public RestfulResponse<CreateKeyResult>createRSAKey() throws Exception {
		CreateKeyRequest createKeyRequest = new CreateKeyRequest();
		createKeyRequest.setAlgorithm(AlgorithmConstant.RSA.getCode());
		return new RestfulResponse<CreateKeyResult>(cryptoFactory.getCryptoAlgorithm(createKeyRequest).createKey(createKeyRequest));
	}

}
