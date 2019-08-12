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
import com.encryptionApp.vo.CryptoTextRequest;
import com.encryptionApp.vo.DecryptResult;
import com.encryptionApp.vo.EncryptResult;
import com.encryptionApp.vo.RestfulResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "PBECrypto")
public class PBECryptoController {
	
	@Autowired
	private CryptoFactory cryptoFactory;
	
	/**
	 * @see 進行PBE資料加密
	 * @param CryptoBaseRequest
	 * @return RestfulResponse<EncryptResult>
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行PBE資料加密", notes = "進行PBE資料加密")
	@RequestMapping(value = "doPBEEncrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<EncryptResult> doPBEEncrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.PBE.getCode());
		return new RestfulResponse<EncryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getEncryptResult(cryptoTextRequest));
	}
	
	/**
	 * @see 進行PBE資料解密
	 * @param CryptoBaseRequest
	 * @return RestfulResponse<DecryptResult>
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行PBE資料解密", notes = "進行PBE資料解密")
	@RequestMapping(value = "doPBEDecrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<DecryptResult> doPBEDecrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.PBE.getCode());
		return new RestfulResponse<DecryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getDecryptResult(cryptoTextRequest));
	}

}
