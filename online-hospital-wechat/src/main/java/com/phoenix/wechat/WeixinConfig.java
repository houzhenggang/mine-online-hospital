package com.phoenix.wechat;

import lombok.Data;

/**
 * 微信配置
 *
 * @since 0.1.3
 */
@Data
public class WeixinConfig {

	/**
	 * 开发者第三方用户唯一凭证
	 */
	private String appid;
	/**
	 * 开发者第三方用户唯一凭证密钥
	 */
	private String secret;
	/**
	 * 公众号原始ID
	 */
	private String originalid;
	/**
	 * 消息加密方式 0:明文模式(默认), 1:兼容模式, 2:安全模式(推荐)
	 */
	private int encodingtype = 0;
	/**
	 * 消息加密密钥(43位字符组成A-Za-z0-9)
	 */
	private String encodingaeskey;
	/**
	 * 网页安全授权URL
	 */
	private String oauthUrl;
	/**
	 * 公众平台接口域名
	 */
	private String apiDomain = "api.weixin.qq.com";

}
