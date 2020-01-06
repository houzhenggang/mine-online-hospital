package com.phoenix.wechat.spi;

import javax.servlet.ServletInputStream;
import com.phoenix.wechat.WeixinException;

/**
 * 输入消息处理器
 *
 * @since 0.0.6
 */
public interface IMessageHandler {

    /**
     * 微信输入消息处理器
     *
     * @param inputStream 输入流
     * @return 返回xml格式的回复消息
     * @throws WeixinException 微信操作异常
     */
    String invoke(ServletInputStream inputStream) throws WeixinException;

    /**
     * 微信输入消息处理器
     *
     * @param inputXml 输入xml
     * @return 返回xml格式的回复消息
     * @throws WeixinException 微信操作异常
     */
    String invoke(String inputXml) throws WeixinException;
}
