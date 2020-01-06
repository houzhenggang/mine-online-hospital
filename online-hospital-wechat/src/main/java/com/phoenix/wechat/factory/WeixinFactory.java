package com.phoenix.wechat.factory;

import com.phoenix.wechat.Weixin;

/**
 * 创建一个微信操作工厂类
 *
 * @since 1.0.0
 */
public interface WeixinFactory {

    Weixin getWeixin();
}
