package com.encryptionApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encryptionApp.vo.CryptoBaseRequest;
import com.encryptionApp.vo.RestfulResponse;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "crypto")
public class CryptoController {

//	@Autowired
//	private ICryptoService cryptoService;

	/**
	 * @see 進行BASE64資料加密
	 * @param CryptoBaseRequest
	 * @return
	 */
	@ApiOperation(value = "進行BASE64資料加密", notes = "進行BASE64資料加密")
	@RequestMapping(value = "doBASE64encrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest> doBASE64encrypt(String text) {
		return null;
	}
	
	/**
	 * @see 進行BASE64資料解密
	 * @param CryptoBaseRequest
	 * @return
	 */
	@ApiOperation(value = "進行BASE64資料解密", notes = "進行BASE64資料解密")
	@RequestMapping(value = "doBASE64decrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest> doBASE64decrypt(String text) {
		return null;
	}
	
	/**
	 * @see 進行AES資料加密
	 * @param CryptoBaseRequest
	 * @return
	 */
	@ApiOperation(value = "進行AES資料加密", notes = "進行AES資料加密")
	@RequestMapping(value = "deAESencrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest> deAESencrypt(String text) {
		return null;
	}

	/**
	 * @see 進行AES資料解密
	 * @param CryptoBaseRequest
	 * @return
	 */
	@ApiOperation(value = "進行AES資料解密", notes = "進行AES資料解密")
	@RequestMapping(value = "deAESdecrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest> deAESdecrypt(String text) {
		return null;
	}
	
	/**
	 * @see 進行RSA資料加密
	 * @param CryptoBaseRequest
	 * @return
	 */
	@ApiOperation(value = "進行RSA資料加密", notes = "進行RSA資料加密")
	@RequestMapping(value = "doRSAencrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest> doRSAencrypt(String text) {
		return null;
	}
	
	/**
	 * @see 進行RSA資料解密
	 * @param CryptoBaseRequest
	 * @return
	 */
	@ApiOperation(value = "進行RSA資料解密", notes = "進行RSA資料解密")
	@RequestMapping(value = "deRSAdecrypt", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest> deRSAdecrypt(String text) {
		return null;
	}
	
	/**
	 * @see 產生RSA金鑰
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	@ApiOperation(value = "產生RSA金鑰", notes = "產生RSA金鑰")
	@RequestMapping(value = "createRSAKey", method = RequestMethod.POST)
	@ResponseBody
	public RestfulResponse<CryptoBaseRequest>createRSAKey() {
		return null;
	}
}

