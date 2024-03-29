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
@RequestMapping(value = "BASE64Crypto")
public class BASE64CryptoController {

	@Autowired
	private CryptoFactory cryptoFactory;

	/**
	 * @see 進行BASE64資料加密
	 * @param CryptoBaseRequest
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行BASE64資料加密", notes = "進行BASE64資料加密")
	@RequestMapping(value = "doBASE64Encrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<EncryptResult> doBASE64Encrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.BASE64.getCode());
		return new RestfulResponse<EncryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getEncryptResult(cryptoTextRequest));
	}
	
	/**
	 * @see 進行BASE64資料解密
	 * @param CryptoBaseRequest
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "進行BASE64資料解密", notes = "進行BASE64資料解密")
	@RequestMapping(value = "doBASE64Decrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<DecryptResult> doBASE64Decrypt(@Valid @RequestBody CryptoTextRequest cryptoTextRequest) throws Exception {
		cryptoTextRequest.setAlgorithm(AlgorithmConstant.BASE64.getCode());
		return new RestfulResponse<DecryptResult>(cryptoFactory.getCryptoAlgorithm(cryptoTextRequest).getDecryptResult(cryptoTextRequest));
	}
}

