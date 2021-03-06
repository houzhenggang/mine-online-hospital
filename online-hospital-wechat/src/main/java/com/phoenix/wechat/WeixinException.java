package com.phoenix.wechat;

/**
 *
 * 微信操作全局异常
 *
 * @since 0.0.1
 */
public class WeixinException extends Exception {

    public WeixinException(String msg) {
        super(msg);
    }

    public WeixinException(Exception cause) {
        super(cause);
    }

    public WeixinException(String msg, Exception cause) {
        super(msg, cause);
    }
}
