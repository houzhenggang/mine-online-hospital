package com.phoenix.wechat.model.js;

import java.io.Serializable;

import lombok.Data;

/**
 * 微信js接口config配置
 * 
 * @since 0.0.1
 */
@Data
public class WxConfig implements Serializable {

	private static final long serialVersionUID = 3545033771231630410L;
	
	private String appId;
	
	private String timestamp;
	
	private String nonceStr;
	
	private String signature;

}
