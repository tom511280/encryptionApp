package com.encryptionApp.vo;

/**
 * Api Response 物件
 *
 */
public class RestfulResponse<T> extends BaseResponse {

	/**
	 * 回覆資料
	 */
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 回傳成功建構式
	 * @param data
	 */
	public RestfulResponse(T data) {
		this.data = data;
	}
	
	/**
	 * 回傳失敗建構式
	 * @param rc
	 * @param rm
	 */
	public RestfulResponse(String code,String msg) {
		super.setCode(code);;
		super.setMsg(msg);
	}

	@Override
	public String toString() {
		return "RestfulResponse [rc=" + getCode() + ", rm=" + getMsg() + ", data=" + data + "]";
	}
	
}
